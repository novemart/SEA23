import { Link, NavLink } from 'react-router-dom'
import logo from './images/qalogo.svg'
import React from 'react'

const Header = () => {
  return (
    <header>
        <nav className='navbar navbar-expand-sm'>
            <a href="https://www.qa.com"
            className='navbar-brand' target="_blank"
            rel="noreferrer"><img src={logo} alt="QA Ltd"
            width="100"></img></a>
            <Link to="/" className='navbar-brand'>Todo App</Link>
            <div className='collapse navbar-collapse'>
              <ul className="navbar-nav mr-auto">
                <li className="navbar-item">
                  <NavLink to="/" className="nav-link" activeClassName="nav-link active">
                    All Todos
                  </NavLink>
                </li>
                <li className="navbar-item">
                  <NavLink to="/add" className="nav-link" activeClassName="nav-link active">
                    Add Todos
                  </NavLink>
                </li>
              </ul>
            </div>
        </nav>
        </header>
  )
}

export default Header