
use qaxpert;
CREATE TABLE webform (
	name varchar(255),
	
	
	email varchar(255),
	
    edad varchar(3)
)

INSERT INTO webform (name, email, edad) VALUES
('Juan Perez', 'juan@example.com', '25'),
('María Rodríguez', 'maria@example.com', '30'),
('Carlos García', 'carlos@example.com', '22'),
('Laura Martínez', 'laura@example.com', '28'),
('Alejandro López', 'alejandro@example.com', '35'),
('Ana Gómez', 'ana@example.com', '29'),
('Pedro Sánchez', 'pedro@example.com', '26'),
('Carmen Torres', 'carmen@example.com', '31'),
('Miguel Ruiz', 'miguel@example.com', '27'),
('Isabel Jiménez', 'isabel@example.com', '32');

select * from webform
