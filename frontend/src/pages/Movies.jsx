import React, {useEffect, useState} from 'react'
import { fetchMovies, createMovie } from '../services/api'

export default function Movies(){
  const [movies, setMovies] = useState([])
  const [title, setTitle] = useState('')
  const [language, setLanguage] = useState('')
  const [duration, setDuration] = useState(90)
  const [genre, setGenre] = useState('')

  useEffect(()=>{
    fetchMovies().then(setMovies).catch(console.error)
  },[])

  const submit = async (e)=>{
    e.preventDefault()
    try{
      await createMovie({title, language, duration, genre})
      setMovies(await fetchMovies())
    }catch(err){ console.error(err) }
  }

  return (
    <section>
      <h2>Movies</h2>
      <form onSubmit={submit}>
        <label>Title<input value={title} onChange={e=>setTitle(e.target.value)} required/></label>
        <label>Language<input value={language} onChange={e=>setLanguage(e.target.value)} required/></label>
        <label>Duration<input type="number" value={duration} onChange={e=>setDuration(e.target.value)} required/></label>
        <label>Genre<input value={genre} onChange={e=>setGenre(e.target.value)} required/></label>
        <button type="submit">Create Movie</button>
      </form>

      <ul>
        {movies.map(m=> (
          <li key={m.id}>{m.title} — {m.language} — {m.duration} min — {m.genre}</li>
        ))}
      </ul>
    </section>
  )
}
