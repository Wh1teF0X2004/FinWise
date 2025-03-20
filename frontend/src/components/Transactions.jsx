import React, { useEffect, useState } from 'react';
import api from '../services/api';

const Transactions = () => {
    const [transactions, setTransactions] = useState([]);

    useEffect(() => {
        const fetchTransactions = async () => {
            try {
                const response = await api.get('/transactions/user/1');
                setTransactions(response.data);
            } catch (error) {
                console.error('Failed to fetch transactions', error);
            }
        };
        fetchTransactions();
    }, []);

    return (
        <div style={styles.container}>
            <h1>Transactions</h1>
            <ul style={styles.list}>
                {transactions.map(transaction => (
                    <li key={transaction.transId} style={styles.listItem}>
                        {transaction.transAmount} - {transaction.transType}
                    </li>
                ))}
            </ul>
        </div>
    );
};

const styles = {
    container: {
        padding: '20px',
    },
    list: {
        listStyle: 'none',
        padding: '0',
    },
    listItem: {
        padding: '10px',
        borderBottom: '1px solid #ccc',
    },
};

export default Transactions;