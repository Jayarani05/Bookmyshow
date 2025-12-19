import React, {useEffect, useState} from 'react'
import { fetchSeats, createSeat, fetchScreens } from '../services/api'

export default function Seats(){
  const [seats, setSeats] = useState([])
  const [seatNumber, setSeatNumber] = useState('')
  const [seatType, setSeatType] = useState('REGULAR')
  const [screenId, setScreenId] = useState('')
  const [screens, setScreens] = useState([])

  useEffect(()=>{ fetchSeats().then(setSeats).catch(console.error); fetchScreens().then(setScreens).catch(console.error) },[])

  const submit = async (e)=>{
    e.preventDefault()
    try{
      await createSeat({seatNumber, seatType, screenId})
      setSeatNumber('')
      setSeats(await fetchSeats())
    }catch(err){ console.error(err) }
  }

  return (
    <section>
      <h2>Seats</h2>
      <form onSubmit={submit}>
        <label>Seat number<input value={seatNumber} onChange={e=>setSeatNumber(e.target.value)} required/></label>
        <label>Seat type
          <select value={seatType} onChange={e=>setSeatType(e.target.value)}>
            <option>REGULAR</option>
            <option>PREMIUM</option>
          </select>
        </label>
        <label>Screen
          <select value={screenId} onChange={e=>setScreenId(e.target.value)} required>
            <option value="">--select--</option>
            {screens.map(s=> <option key={s.id} value={s.id}>{s.name}</option>)}
          </select>
        </label>
        <button type="submit">Create Seat</button>
      </form>

      <ul>
        {seats.map(s=> <li key={s.id}>{s.seatNumber} — {s.seatType} — screen: {s.screen?.name || s.screen}</li>)}
      </ul>
    </section>
  )
}