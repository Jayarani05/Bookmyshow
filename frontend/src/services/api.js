const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080'

async function handleRes(res){
  if(!res.ok){
    const txt = await res.text().catch(()=>null)
    throw new Error(txt || 'API error')
  }
  return res.status === 204 ? null : res.json()
}

export async function fetchMovies(){
  return handleRes(await fetch(`${API_URL}/movies`))
}

export async function createMovie(body){
  return handleRes(await fetch(`${API_URL}/movies`, { method: 'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(body)}))
}

export async function fetchShows(){
  return handleRes(await fetch(`${API_URL}/shows`))
}

export async function createShow(body){
  return handleRes(await fetch(`${API_URL}/shows`, { method: 'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(body)}))
}

export async function fetchSeats(){
  return handleRes(await fetch(`${API_URL}/seats`))
}

export async function createSeat(body){
  return handleRes(await fetch(`${API_URL}/seats`, { method: 'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(body)}))
}

export async function fetchScreens(){
  return handleRes(await fetch(`${API_URL}/screens`))
}

export async function fetchUsers(){
  return handleRes(await fetch(`${API_URL}/users`))
}

export async function createUser(body){
  return handleRes(await fetch(`${API_URL}/users`, { method: 'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(body)}))
}

export async function createBooking(body){
  return handleRes(await fetch(`${API_URL}/bookings`, { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(body)}))
}

export async function makePayment(bookingId){
  return handleRes(await fetch(`${API_URL}/payments/${bookingId}`, { method: 'POST' }))
}
