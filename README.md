## 🧪 Comparativo: Pruebas Manuales vs Automatizadas

En este ejercicio se desarrolló una prueba automatizada para el método `addPrestamo()` del servicio de préstamos de una biblioteca.  
El propósito fue comparar el esfuerzo y tiempo que implicaría validar este mismo comportamiento de forma **manual** frente a hacerlo **automatizadamente**.

### 🧍‍♂️ Pruebas Manuales

En un escenario de pruebas manuales, un desarrollador o tester tendría que:

1. Levantar la aplicación.
2. Ingresar con un usuario válido.
3. Buscar un libro disponible.
4. Registrar un préstamo desde la interfaz.
5. Verificar que el libro haya reducido su cantidad en 1.
6. Confirmar que el préstamo se haya asociado correctamente al usuario.
7. Repetir las pruebas para distintos usuarios o libros.

Este proceso podría tomar entre **10 y 15 minutos por caso de prueba**, además de depender de la disponibilidad del sistema, la base de datos y la intervención humana.  
También existe un alto riesgo de **errores por descuido** o **omisión de pasos**.

---

### Pruebas Automatizadas

En cambio, con la prueba automatizada desarrollada con **JUnit 5 y Mockito**, el proceso se realiza de forma completamente automática:

- Los datos se simulan mediante mocks, sin necesidad de conectarse a una base de datos real.
- La ejecución del test y la verificación de resultados ocurre en segundos.
- Puede repetirse ilimitadamente sin intervención manual.
- La cobertura se mide automáticamente con **JaCoCo**, permitiendo identificar qué partes del código fueron realmente validadas.

El mismo escenario que tomaría varios minutos en pruebas manuales se ejecuta en **menos de un segundo**, con resultados objetivos y reproducibles.

---

### Conclusión

| Aspecto                      | Pruebas Manuales                   | Pruebas Automatizadas                     |
|------------------------------|------------------------------------|-------------------------------------------|
| Tiempo por ejecución         | 10–15 minutos                      | < 1 segundo                              |
| Intervención humana          | Alta                               | Nula (una vez implementadas)              |
| Confiabilidad                | Variable (puede haber errores)     | Alta (resultados consistentes)            |
| Repetibilidad                | Limitada                           | Ilimitada                                 |
| Reporte de cobertura         | No aplica                          | Automático (JaCoCo)                       |
| Escalabilidad                | Difícil de mantener                | Fácil de integrar en CI/CD                |

Gracias a la **automatización**, el equipo puede garantizar que los cambios en el código no rompan la funcionalidad de los préstamos, mejorando la **calidad del software** y reduciendo significativamente el **tiempo de validación** en futuros desarrollos.

---

## Resultado de cobertura
<img width="977" height="249" alt="test prestamo" src="https://github.com/user-attachments/assets/c0491bb1-44aa-4856-adeb-543593e58f33" />

--- 
## ⚙️ Instrucciones de instalación y ejecución

Este proyecto fue desarrollado con **Spring Boot** y utiliza **Gradle** como sistema de construcción y gestión de dependencias.

### 🔧 Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instaladas las siguientes herramientas:

- **Java 17** o superior  
- **Gradle 8+** (opcional, ya que el proyecto incluye el *Gradle Wrapper*)  
- **Git** (si clonas el repositorio desde GitHub)

---

### 📥 Clonar el repositorio

```bash
git clone https://github.com/<tu-usuario>/<nombre-del-repositorio>.git
cd <nombre-del-repositorio>


