CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    user_email VARCHAR(100) UNIQUE NOT NULL,
    user_password VARCHAR(100) NOT NULL,
    user_birthdate DATE
);

CREATE TABLE categories (
    cat_id SERIAL PRIMARY KEY, -- Auto-incrementing primary key
    cat_name VARCHAR(100) UNIQUE NOT NULL -- Unique category name
);

CREATE TABLE transactions (
    trans_id SERIAL PRIMARY KEY, -- Auto-incrementing primary key
    trans_amount DECIMAL(10, 2) NOT NULL, -- Transaction amount (up to 10 digits, 2 decimal places)
    trans_type VARCHAR(10) CHECK (trans_type IN ('income', 'expense')) NOT NULL, -- Type of transaction
    cat_id INT REFERENCES categories(cat_id) ON DELETE SET NULL, -- Foreign key to categories
    trans_date DATE NOT NULL, -- Transaction date
    user_id INT REFERENCES users(user_id) ON DELETE CASCADE -- Foreign key to users
);

CREATE TABLE budgets (
    bud_id SERIAL PRIMARY KEY, -- Auto-incrementing primary key
    cat_id INT REFERENCES categories(cat_id) ON DELETE CASCADE, -- Foreign key to categories
    bud_amount DECIMAL(10, 2) NOT NULL, -- Budget amount
    user_id INT REFERENCES users(user_id) ON DELETE CASCADE -- Foreign key to users
);

CREATE TABLE goals (
    goal_id SERIAL PRIMARY KEY, -- Auto-incrementing primary key
    target_amount DECIMAL(10, 2) NOT NULL, -- Target amount for the goal
    current_amount DECIMAL(10, 2) DEFAULT 0, -- Current amount saved (default 0)
    goal_deadline DATE NOT NULL, -- Deadline for the goal
    user_id INT REFERENCES users(user_id) ON DELETE CASCADE -- Foreign key to users
);