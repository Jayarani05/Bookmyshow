import React, { useState } from 'react'
import { BrowserRouter, Routes, Route, NavLink } from 'react-router-dom'
import Movies from './pages/Movies'
import Shows from './pages/Shows'
import Booking from './pages/Booking'
import Payment from './pages/Payment'
import Users from './pages/Users'
import Seats from './pages/Seats'

export default function App(){
  const [open, setOpen] = useState(false)
  return (
    <BrowserRouter>
      <div className="app">
        <header>
          <div className="header-brand">
            <div className="header-logo" aria-hidden="true">
              <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M3 12h18M3 6h18M3 18h18" stroke="white" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round"/></svg>
            </div>
            <h1>BookMyShow</h1>
          </div>

          <button className="nav-toggle" aria-label="Toggle menu" onClick={() => setOpen(o => !o)}>☰</button>

          <nav className={`main-nav ${open ? 'open' : ''}`}>
            <NavLink to="/" className={({isActive}) => 'nav-link' + (isActive ? ' active' : '')}>Movies</NavLink>
            <NavLink to="/shows" className={({isActive}) => 'nav-link' + (isActive ? ' active' : '')}>Shows</NavLink>
            <NavLink to="/booking" className={({isActive}) => 'nav-link' + (isActive ? ' active' : '')}>Booking</NavLink>
            <NavLink to="/payment" className={({isActive}) => 'nav-link' + (isActive ? ' active' : '')}>Payment</NavLink>
            <NavLink to="/users" className={({isActive}) => 'nav-link' + (isActive ? ' active' : '')}>Users</NavLink>
            <NavLink to="/seats" className={({isActive}) => 'nav-link' + (isActive ? ' active' : '')}>Seats</NavLink>
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
