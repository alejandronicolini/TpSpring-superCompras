<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
          integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<main>
<h2 class="pb-2 border-bottom">App SuperCompras <i class="fa-solid fa-check"></i></h2>
<h3 class="pb-2">"Curso Spring - Codo a Codo 4.0"</h3>
<h6 class="pb-2"><i class="fa-solid fa-book"></i> - Api Rest, para simular la compra de productos ingresados en un carrito</h6>
<p class="pb-2 text-black border-bottom"><i class="fa-sharp fa-solid fa-user-secret"></i> - Estudiante: Nicolini Alejandro</p>
    <div class="container px-4 py-5 bg-mid-gray" id="featured-3">
        <h2 class="pb-2 border-bottom">EndPoints para la Base de datos SQL <i class="fa-solid fa-database"></i></h2>
        <p class="alert alert-success" role="alert">Atencion: Debe crearse un Base de Datos vacía de nombre "carrito_db" para que luego Spring cree las tablas. Luego ya puede utilizarse la app normalmente</p>
        <p class="alert alert-secondary" role="alert"><i class="fa-solid fa-earth-americas"></i> -Link a la documentación con Swagger: http://localhost:8080/swagger-ui/index.html</p>
        <h3 class="card-title"><strong>Los endpoint son:</strong></h3>
        <div class="row g-4 py-3 row-cols-1 row-cols-lg-2">
            <div class="feature col">
                <div class="feature-icon bg-primary bg-gradient">
                    <svg class="bi" height="1em"></svg>
                </div>
                <div class="row">
                    <div class="col-2">
                        <i class="fa-solid fa-table fa-2x"></i>
                    </div>
                    <h3 class="col">Tabla Carrito</h3>
                </div>
                <p class="text-black">Get: /carrito/listado "Listado de carritos de compras en la base de datos"</p>
                <p class="text-black">Get: /carrito/{id} "Consulta contenido de carrito de compras por su ID"</p>
                <p class="text-black">Get: /carrito/{id}/totalCompra "Consulta el monto total del carrito de compras por ID"</p>
                <p class="text-black">Post: /carrito/new "Creación de un carrito de compras vacío"</p>
                <p class="text-black">Post: /carrito/new2 "Creación de un carrito de compras con productos"</p>
                <p class="text-black">Put: /carrito/{id}/addProducto "Agregar un producto al carrito de compras" </p>
                <p class="text-black">Put: /carrito/{id}/addProductoV2 -"Agregar un producto al carrito de compras V2"</p>
                <p class="text-black">Put: /carrito/update/{id} "Actualizar todo el carrito de compras"</p>
                <p class="text-black">Delete: /carrito/delete/{id} "Eliminar el carrito de compras y los producto de la BD"</p>
            </div>
            <div class="feature col">
                <div class="feature-icon bg-primary bg-gradient">
                    <svg class="bi" height="1em"></svg>
                </div>
                <div class="row">
                    <div class="col-2">
                        <i class="fa-solid fa-table fa-2x"></i>
                    </div>
                    <h3 class="col">Tabla Productos</h3>
                </div>
                <p class="text-black">Get: /productos/{id} "Consultar un producto por su ID"</p>
                <p class="text-black">Get: /productos/listado "Listado de productos en la base de datos"</p>
                <p class="text-black">Post: /productos/new "Creación de un producto"</p>
                <p class="text-black">Put: /productos/update/{id} "Actualizar información de un Producto existente, por su ID"</p>
                <p class="text-black">Delete: /productos/delete/{id} "Eliminar el producto de la BD"</p>
            </div>
        </div>
    </div>
</main>