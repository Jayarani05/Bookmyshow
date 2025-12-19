import React, {useState} from 'react'
import { makePayment } from '../services/api'

export default function Payment(){
  const [bookingId, setBookingId] = useState('')
  const [result, setResult] = useState(null)

  const submit = async (e)=>{
    e.preventDefault()
    try{
      const p = await makePayment(bookingId)
      setResult(p)
    }catch(err){
      console.error(err)
      setResult({ error: err.message })
    }
  }

  return (
    <section>
      <h2>Make Payment</h2>
      <form onSubmit={submit}>
        <label>Booking ID<input value={bookingId} onChange={e=>setBookingId(e.target.value)} required/></label>
        <button type="submit">Pay</button>
      </form>
      {result && <pre>{JSON.stringify(result, null, 2)}</pre>}
    </section>
  )
}
