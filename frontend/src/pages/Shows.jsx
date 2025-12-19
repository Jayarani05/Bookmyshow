import React, {useEffect, useState} from 'react'
import { fetchShows, fetchMovies, fetchScreens, createShow } from '../services/api'

export default function Shows(){
  const [shows, setShows] = useState([])
  const [movies, setMovies] = useState([])
  const [screens, setScreens] = useState([])
  const [movieId, setMovieId] = useState('')
  const [screenId, setScreenId] = useState('')
  const [startTime, setStartTime] = useState('')
  const [price, setPrice] = useState('')

  useEffect(()=>{
    fetchShows().then(setShows).catch(console.error)
    fetchMovies().then(setMovies).catch(console.error)
    fetchScreens().then(setScreens).catch(console.error)
  },[])

  const submit = async (e)=>{
    e.preventDefault()
    try{
      await createShow({movieId, screenId, startTime, price})
      setShows(await fetchShows())
    }catch(err){ console.error(err) }
  }

  return (
    <section>
      <h2>Shows</h2>

      <form onSubmit={submit}>
        <div className="form-grid">
          <label>Movie
            <select value={movieId} onChange={e=>setMovieId(e.target.value)} required>
              <option value="">--select--</option>
              {movies.map(m=> <option key={m.id} value={m.id}>{m.title}</option>)}
            </select>
          </label>
          <label>Screen
            <select value={screenId} onChange={e=>setScreenId(e.target.value)} required>
              <option value="">--select--</option>
              {screens.map(s=> <option key={s.id} value={s.id}>{s.name}</option>)}
            </select>
          </label>
          <label>Start time<input type="datetime-local" value={startTime} onChange={e=>setStartTime(e.target.value)} required/></label>
          <label>Price<input type="number" value={price} onChange={e=>setPrice(e.target.value)} required/></label>
        </div>
        <div className="form-footer">
          <button type="submit">Create Show</button>
        </div>
      </form>

      <ul className="card-list">
        {shows.map(s=> (
          <li key={s.id} className="card">
            <div>
              <div className="title">{s.movie?.title || '—'}</div>
              <div className="meta">Screen: {s.screen?.name || '—'} / {new Date(s.startTime).toLocaleString()}</div>
            </div>
            <div className="meta">${s.price}</div>
          </li>
        ))}
      </ul>
    </section>
  )
}
