# BookMyShow

## Frontend (React)

A minimal React (Vite) frontend is available under the `frontend/` folder.

Quickstart:

1. Start MongoDB locally (default expects `mongodb://localhost:27017/bookmyshow`).
2. Start the backend: `./mvnw.cmd spring-boot:run` (ensure Java 17+ is installed).
3. Start the frontend:
   - cd `frontend`
   - `npm install`
   - `npm run dev` (default: `http://localhost:5173`)

Set `VITE_API_URL` if your backend runs on a different host/port.