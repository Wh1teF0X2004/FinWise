import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
    return (
        <nav style={styles.nav}>
            <Link to="/" style={styles.link}>Home</Link>
            <Link to="/login" style={styles.link}>Login</Link>
            <Link to="/register" style={styles.link}>Register</Link>
            <Link to="/dashboard" style={styles.link}>Dashboard</Link>
        </nav>
    );
};

const styles = {
    nav: {
        backgroundColor: '#333',
        padding: '10px',
    },
    link: {
        color: '#fff',
        margin: '0 10px',
        textDecoration: 'none',
    },
};

export default Navbar;