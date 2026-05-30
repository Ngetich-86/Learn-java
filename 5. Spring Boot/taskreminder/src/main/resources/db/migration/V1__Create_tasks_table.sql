-- Create tasks table
CREATE TABLE IF NOT EXISTS tasks (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    due_date TIMESTAMP,
    completed BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create index on due_date for better performance
CREATE INDEX IF NOT EXISTS idx_tasks_due_date ON tasks(due_date);

-- Create index on completed status
CREATE INDEX IF NOT EXISTS idx_tasks_completed ON tasks(completed); 