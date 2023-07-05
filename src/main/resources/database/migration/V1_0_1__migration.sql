CREATE TABLE IF NOT EXISTS USERS(
                                    user_id INTEGER GENERATED ALWAYS AS IDENTITY,
                                    name VARCHAR(20) NOT NULL,
                                    PRIMARY KEY(user_id)
);

CREATE TABLE IF NOT EXISTS BLOGS(
                                    blog_id INTEGER GENERATED ALWAYS AS IDENTITY,
                                    user_id INTEGER,
                                    title VARCHAR(20) NOT NULL,
                                    content VARCHAR(100) NOT NULL,
                                    time_created TIME,
                                    time_last_modified TIME,
                                    PRIMARY KEY(blog_id),
                                    CONSTRAINT user_exists FOREIGN KEY(user_id) REFERENCES USERS(user_id)
);