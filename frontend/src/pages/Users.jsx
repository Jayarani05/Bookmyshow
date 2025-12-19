import React, {useEffect, useState} from 'react'
import { fetchUsers, createUser } from '../services/api'

export default function Users(){
  const [users, setUsers] = useState([])
  const [name, setName] = useState('')
  const [email, setEmail] = useState('')
  const [phone, setPhone] = useState('')

  useEffect(()=>{ fetchUsers().then(setUsers).catch(console.error) },[])

  const submit = async (e)=>{
    e.preventDefault()
    try{
      await createUser({name,email,phone})
      setName(''); setEmail(''); setPhone('')
      setUsers(await fetchUsers())
    }catch(err){ console.error(err) }
  }

  return (
    <section>
      <h2>Users</h2>
      <form onSubmit={submit}>
        <label>Name<input value={name} onChange={e=>setName(e.target.value)} required/></label>
        <label>Email<input value={email} onChange={e=>setEmail(e.target.value)} required/></label>
        <label>Phone<input value={phone} onChange={e=>setPhone(e.target.value)} required/></label>
        <button type="submit">Create User</button>
      </form>

      <ul>
        {users.map(u=> <li key={u.id}>{u.name} — {u.email} — {u.phone}</li>)}
      </ul>
    </section>
  )
}