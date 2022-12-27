-- Nombre Base de datos a crear previamente: `carrito_db`
use carrito_db;

-- Volcado de datos para la tabla `carrito`. Aqui se estan creando 2 carritos
INSERT INTO `carrito` (`id_carrito`) VALUES
(1),
(2);

-- Volcado de datos para la tabla `productos`
INSERT INTO `productos` (`id_producto`, `categoria`, `descripcion`, `foto`, `nombre`, `precio`, `subcategoria`, `tamanio`, `tipo`, `id_chango`) VALUES
(1, 'Bebidas', NULL, NULL, 'Té Dharamsala', 18, NULL, 20, NULL, 1),
(2, 'Condimentos', NULL, NULL, 'Sirope de regaliz', 10, NULL, 550, NULL, 1),
(3, 'Cuidado Personal', 'Acondicionador Elvive Hidra Hialurónico x 400 ml', NULL, 'Acondicionador Elvive Hidra Hialurónico ', 891, 'Shampoo Y Acondicionador', 400, NULL, 1),
(4, 'Alimentación Saludable', 'Galletitas Bagley Cereales con Avena x 155 gr', NULL, 'Galletitas Bagley Cereales con Avena', 260.5, 'Galletitas y Tostadas', 155, NULL, 1);
