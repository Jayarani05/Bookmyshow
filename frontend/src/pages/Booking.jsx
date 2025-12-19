import React, {useEffect, useState} from 'react'
import { createBooking, fetchUsers, fetchShows, fetchSeats } from '../services/api'

export default function Booking(){
  const [users, setUsers] = useState([])
  const [shows, setShows] = useState([])
  const [seats, setSeats] = useState([])

  const [userId, setUserId] = useState('')
  const [showId, setShowId] = useState('')
  const [selectedSeats, setSelectedSeats] = useState(new Set())
  const [result, setResult] = useState(null)

  useEffect(()=>{
    fetchUsers().then(setUsers).catch(console.error)
    fetchShows().then(setShows).catch(console.error)
    fetchSeats().then(setSeats).catch(console.error)
  },[])

  const onToggleSeat = (id)=>{
    const copy = new Set(selectedSeats)
    if(copy.has(id)) copy.delete(id); else copy.add(id)
    setSelectedSeats(copy)
  }

  const submit = async (e)=>{
    e.preventDefault()
    try{
      const seatList = Array.from(selectedSeats)
      const booking = await createBooking({userId, showId, seatIds: seatList})
      setResult(booking)
      setSelectedSeats(new Set())
    }catch(err){
      console.error(err)
      setResult({ error: err.message })
    }
  }

  // Filter seats to the ones for the selected show's screen
  const selectedShow = shows.find(s => s.id === showId)
  const availableSeats = selectedShow ? seats.filter(seat => seat.screen && seat.screen.id === selectedShow.screen?.id) : seats

  return (
    <section>
      <h2>Create Booking</h2>
      <form onSubmit={submit}>
        <label>User
          <select value={userId} onChange={e=>setUserId(e.target.value)} required>
            <option value="">--select user--</option>
            {users.map(u=> <option key={u.id} value={u.id}>{u.name}</option>)}
          </select>
        </label>

        <label>Show
          <select value={showId} onChange={e=>setShowId(e.target.value)} required>
            <option value="">--select show--</option>
            {shows.map(s=> <option key={s.id} value={s.id}>{s.movie?.title} @ {s.screen?.name} — {new Date(s.startTime).toLocaleString()}</option>)}
          </select>
        </label>

        <fieldset>
          <legend>Seats (filtered by show screen)</legend>
          <div className="seat-list">
            {availableSeats.map(seat => (
              <label key={seat.id} className={`seat ${seat.seatType?.toLowerCase() || 'regular'}`}>
                <input type="checkbox" checked={selectedSeats.has(seat.id)} onChange={()=>onToggleSeat(seat.id)} />
                <span className="seat-number">{seat.seatNumber}</span>
                <span className="seat-type">{seat.seatType}</span>
              </label>
            ))}
          </div>
        </fieldset>

        <div className="form-footer">
          <button type="submit">Book</button>
        </div>
      </form>

      {result && (
        <div className="result">
          <h3>Result</h3>
          <pre>{JSON.stringify(result, null, 2)}</pre>
        </div>
      )}
    </section>
  )
}
