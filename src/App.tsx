import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import FlightSearch from './components/FlightSearch/FlightSearch';
import Results from './components/Results/Results';
import Details from './components/Details/Details';


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<FlightSearch />} />
        <Route path="/results" element={<Results />} />
        <Route path="/details/:flightId" element={<Details />} />
      </Routes>
    </Router>
  );
}

export default App;
