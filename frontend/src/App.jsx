import React from 'react'
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom'
import Movies from './pages/Movies'
import Shows from './pages/Shows'
import Booking from './pages/Booking'
import Payment from './pages/Payment'
import Users from './pages/Users'
import Seats from './pages/Seats'

export default function App(){
  return (
    <BrowserRouter>
      <div className="app">
        <header>
          <h1>BookMyShow</h1>
          <nav>
            <Link to="/">Movies</Link>
            <Link to="/shows">Shows</Link>
            <Link to="/booking">Booking</Link>
            <Link to="/payment">Payment</Link>
            <Link to="/users">Users</Link>
            <Link to="/seats">Seats</Link>
          </nav>
        </header>
        <main>
          <Routes>
            <Route path="/" element={<Movies />} />
            <Route path="/shows" element={<Shows />} />
            <Route path="/booking" element={<Booking />} />
            <Route path="/payment" element={<Payment />} />
            <Route path="/users" element={<Users />} />
            <Route path="/seats" element={<Seats />} />
          </Routes>
        </main>
      </div>
    </BrowserRouter>
  )
}
