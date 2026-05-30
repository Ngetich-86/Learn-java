-- Fix ID columns to use BIGSERIAL instead of SERIAL to match JPA entity Long types

-- First, we need to drop the existing sequences and recreate them as BIGSERIAL
-- This is a complex operation that requires careful handling

-- For tasks table
DO $$ 
BEGIN
    -- Drop the existing sequence
    DROP SEQUENCE IF EXISTS tasks_id_seq CASCADE;
    
    -- Alter the column to BIGINT
    ALTER TABLE tasks ALTER COLUMN id TYPE BIGINT;
    
    -- Create a new BIGSERIAL sequence
    CREATE SEQUENCE tasks_id_seq AS BIGINT;
    ALTER SEQUENCE tasks_id_seq OWNED BY tasks.id;
    ALTER TABLE tasks ALTER COLUMN id SET DEFAULT nextval('tasks_id_seq');
    
    -- Set the sequence to start from the current maximum value
    PERFORM setval('tasks_id_seq', COALESCE((SELECT MAX(id) FROM tasks), 0) + 1);
END $$;

-- For users table (if it exists)
DO $$ 
BEGIN
    IF EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = 'users') THEN
        -- Drop the existing sequence
        DROP SEQUENCE IF EXISTS users_id_seq CASCADE;
        
        -- Alter the column to BIGINT
        ALTER TABLE users ALTER COLUMN id TYPE BIGINT;
        
        -- Create a new BIGSERIAL sequence
        CREATE SEQUENCE users_id_seq AS BIGINT;
        ALTER SEQUENCE users_id_seq OWNED BY users.id;
        ALTER TABLE users ALTER COLUMN id SET DEFAULT nextval('users_id_seq');
        
        -- Set the sequence to start from the current maximum value
        PERFORM setval('users_id_seq', COALESCE((SELECT MAX(id) FROM users), 0) + 1);
    END IF;
END $$;

-- For categories table (if it exists)
DO $$ 
BEGIN
    IF EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = 'categories') THEN
        -- Drop the existing sequence
        DROP SEQUENCE IF EXISTS categories_id_seq CASCADE;
        
        -- Alter the column to BIGINT
        ALTER TABLE categories ALTER COLUMN id TYPE BIGINT;
        
        -- Create a new BIGSERIAL sequence
        CREATE SEQUENCE categories_id_seq AS BIGINT;
        ALTER SEQUENCE categories_id_seq OWNED BY categories.id;
        ALTER TABLE categories ALTER COLUMN id SET DEFAULT nextval('categories_id_seq');
        
        -- Set the sequence to start from the current maximum value
        PERFORM setval('categories_id_seq', COALESCE((SELECT MAX(id) FROM categories), 0) + 1);
    END IF;
END $$;

-- For reminders table (if it exists)
DO $$ 
BEGIN
    IF EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = 'reminders') THEN
        -- Drop the existing sequence
        DROP SEQUENCE IF EXISTS reminders_id_seq CASCADE;
        
        -- Alter the column to BIGINT
        ALTER TABLE reminders ALTER COLUMN id TYPE BIGINT;
        
        -- Create a new BIGSERIAL sequence
        CREATE SEQUENCE reminders_id_seq AS BIGINT;
        ALTER SEQUENCE reminders_id_seq OWNED BY reminders.id;
        ALTER TABLE reminders ALTER COLUMN id SET DEFAULT nextval('reminders_id_seq');
        
        -- Set the sequence to start from the current maximum value
        PERFORM setval('reminders_id_seq', COALESCE((SELECT MAX(id) FROM reminders), 0) + 1);
    END IF;
END $$; 