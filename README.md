# 🌸 Floristería "Flores del Valle" - PMV de Gestión Integral
## Producto Mínimo Viable (PMV) - Evidencia de Aprendizaje 2 (EA2)

**Institución Universitaria Digital de Antioquia (IU Digital)**  
**Facultad de Ingeniería – Tecnología en Desarrollo de Software**  
**Asignatura:** Frameworks  
**Unidad 2:** Arquitectura MVC y Motor de Plantillas Thymeleaf  

---

## 👥 1. Conformación del Grupo de Trabajo y Roles

| Integrante | Rol en el Proyecto | Responsabilidades Técnicas |
| :--- | :--- | :--- |
| **Adrianys Saumeth** | **Líder de Proyecto & Desarrollador Backend MVC** | Diseño de arquitectura, implementación de clases controladoras (`@Controller`), capa de servicios (`@Service`), modelos de dominio y gestión del repositorio Git. |
| **Simón Cano Rojas** | **Especialista Frontend & Motor Thymeleaf** | Maquetación responsiva con Bootstrap 5, diseño de vistas dinámicas con directivas Thymeleaf (`th:each`, `th:object`, `th:field`, `th:replace`), componentes modulares (Navbar/Footer) y diseño UX/UI. |
| **Adrianys Saumeth & Simón Cano Rojas** | **Aseguramiento de Calidad (QA) & Documentación** | Pruebas funcionales integrales de endpoints HTTP (status 200/302), validación de flujos de negocio y redacción del informe técnico académico. |

---

## 📋 2. Descripción del Caso de Estudio

**"Flores del Valle"** es una floristería familiar ubicada en una ciudad intermedia, que ha crecido rápidamente gracias a su reputación en arreglos florales personalizados. Sin embargo, la administración manual de inventarios, pedidos y entregas ha generado problemas como:
- Stock insuficiente de flores en temporadas altas (Día de la Madre y San Valentín).
- Pedidos mal gestionados debido a la falta de seguimiento en tiempo real.
- Demoras en entregas por rutas poco optimizadas.
- Errores en facturación y dificultad para analizar ventas.

La propietaria, **Ana María**, busca una solución tecnológica para centralizar operaciones, mejorar la eficiencia y escalar el negocio sin perder la atención personalizada.

Para esta **Evidencia de Aprendizaje 2 (EA2)**, se implementó el **Producto Mínimo Viable (PMV)** aplicando rigurosamente el patrón **MVC (Model-View-Controller)** en Spring Boot con **Thymeleaf**.

---

## 🏗️ 3. Arquitectura del Sistema (Patrón MVC)

```
floresdelvalle/
├── src/main/java/com/floresdelvalle/
│   ├── FloresdelvalleApplication.java
│   ├── controller/               # Capa Controladora (Spring MVC)
│   │   ├── HomeController.java          -> Métricas operacionales y rutas institucionales
│   │   ├── InventarioController.java    -> Control de inventario en tiempo real y alertas
│   │   ├── PedidoController.java        -> Formulario y procesamiento de nuevos pedidos
│   │   ├── EntregaController.java       -> Asignación de conductores y rutas de reparto
│   │   ├── FacturaController.java       -> Generación de facturas y control de pagos
│   │   └── InformeController.java       -> Reportes de ventas y popularidad de arreglos
│   ├── model/                    # Capa de Dominio (Modelos de Datos)
│   │   ├── Flor.java                    -> Entidad de inventario con cálculo de stock crítico
│   │   ├── Pedido.java                  -> Entidad de pedidos de clientes
│   │   ├── Entrega.java                 -> Entidad de logística y rutas de reparto
│   │   ├── Factura.java                 -> Entidad de finanzas y facturación
│   │   └── ArregloFloral.java           -> Entidad de catálogo y popularidad
│   └── service/                  # Capa de Negocio / Servicios
│       ├── FlorService.java             -> Lógica de inventario y descuento automático
│       ├── PedidoService.java           -> Orquestación de pedidos, entregas y facturación
│       ├── EntregaService.java          -> Programación de rutas y asignación de conductores
│       ├── FacturaService.java          -> Emisión de comprobantes y balance financiero
│       └── CatalogoService.java         -> Catálogo de arreglos personalizados
└── src/main/resources/
    └── templates/                # Capa de Presentación (Vistas Thymeleaf)
        ├── fragments/
        │   ├── navbar.html              -> Barra de navegación responsiva
        │   └── footer.html              -> Pie de página corporativo
        ├── index.html                   -> Dashboard principal para Ana María
        ├── inventario.html              -> Tabla de stock con alertas de temporadas
        ├── nuevo-pedido.html            -> Formulario interactivo con binding de modelo
        ├── pedidos.html                 -> Directorio general de pedidos
        ├── entregas.html                -> Rutas de reparto y conductores
        ├── facturas.html                -> Registro de facturas y recaudos
        ├── informes.html                -> Análisis operacional y ventas
        ├── catalogo.html                -> Catálogo público de arreglos
        ├── mision.html                  -> Misión corporativa
        ├── vision.html                  -> Visión estratégica 2028
        └── valores.html                 -> Valores corporativos
```

---

## 🌐 4. Rutas y Endpoints del PMV

| Opción de Menú | Ruta / Endpoint | Método HTTP | Descripción Funcional |
| :--- | :--- | :---: | :--- |
| **Inicio** | `/` | `GET` | Dashboard central con 4 métricas clave (stock total, alertas críticas, pedidos activos, ventas). |
| **Inventario** | `/inventario` | `GET` / `POST` | Control de stock en tiempo real con alertas para San Valentín y Día de la Madre. Registro de lotes. |
| **Pedidos** | `/pedidos` | `GET` | Listado general con seguimiento de estados (En curso, Completado, Entregado). |
| **Nuevo Pedido** | `/pedidos/nuevo` | `GET` / `POST` | Formulario con enlace de modelo (`th:object`). Al registrar, descuenta inventario y programa entrega y factura. |
| **Entregas** | `/entregas` | `GET` | Control logístico de asignación de conductores (Carlos Ruiz, Andrés Montoya) y zonas de reparto. |
| **Facturación** | `/facturacion` | `GET` | Historial de facturas generadas con desglose de subtotal flores, costo de envío y medios de pago. |
| **Informes** | `/informes` | `GET` | Reportes de ventas e indicadores de popularidad de arreglos florales. |
| **Catálogo** | `/catalogo` | `GET` | Galería de arreglos personalizados con precios sugeridos y ocasiones. |
| **Institucional** | `/mision`, `/vision`, `/valores` | `GET` | Información estratégica y corporativa de Flores del Valle. |

---

## ⚙️ 5. Instrucciones de Ejecución

```bash
# 1. Clonar el repositorio
git clone https://github.com/adrianys2005/floresdelvalle-pmv.git
cd floresdelvalle

# 2. Ejecutar con Maven Wrapper
./mvnw spring-boot:run

# 3. Acceder en el navegador
http://localhost:8080
```
