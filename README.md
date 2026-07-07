# Reto de Aplicación de Código Limpio y Eficiente

El sistema de gestión de portafolio de inversiones necesita ser robusto y mantenible. Cada inversión tiene identificador, nombre, valor, fecha de adquisición y tipo. El sistema debe permitir agregar, actualizar y eliminar inversiones, asegurando que no haya duplicados y que los valores sean positivos. Tu tarea es aplicar principios de código limpio y eficiente para desarrollar estas funcionalidades.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Aplicación de Código limpio y eficiente |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 4-5 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: Un IDE o editor de código.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Verifica que el proyecto arranca sin errores.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Implementación Inicial

**Objetivo:** Crear las funcionalidades básicas para gestionar inversiones.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Define la estructura de datos para representar una inversión.
- Implementa la funcionalidad para agregar una inversión, asegurándote de que no haya duplicados y que los valores sean positivos.

**Entregable:** Funcionalidad para agregar inversiones con validaciones.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo representar los datos para facilitar futuras extensiones y mantenimiento.
- Piensa en cómo manejar los errores de validación de manera limpia y eficiente.

</details>

### Fase 2: Actualización y Eliminación de Inversiones

**Objetivo:** Extender las funcionalidades para actualizar y eliminar inversiones.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Implementa la funcionalidad para actualizar una inversión, asegurándote de mantener las validaciones.
- Implementa la funcionalidad para eliminar una inversión.

**Entregable:** Funcionalidades para actualizar y eliminar inversiones con validaciones.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo mantener la coherencia y consistencia de los datos al actualizar y eliminar inversiones.
- Piensa en cómo hacer que estas funcionalidades sean eficientes y escalables.

</details>

### Fase 3: Refactorización y Optimización

**Objetivo:** Refactorizar el código para mejorar su limpieza y eficiencia.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Revisa el código implementado y aplica principios de código limpio (KISS, SOLID, YAGNI y DRY).
- Identifica y elimina cualquier duplicación de código y optimiza las funcionalidades.

**Entregable:** Código refactorizado y optimizado siguiendo principios de código limpio.

<details>
<summary>Pistas de conocimiento</summary>

- Aplica los principios de código limpio para mejorar la legibilidad y mantenibilidad del código.
- Identifica oportunidades para eliminar duplicidades y optimizar el rendimiento.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué significa aplicar principios de código limpio en este contexto?
- **paraQueSirve**: ¿Para qué sirven las validaciones en la funcionalidad de agregar inversiones?
- **comoSeUsa**: ¿Cómo se usa la estructura de datos para representar una inversión?
- **erroresComunes**: ¿Qué errores comunes se pueden encontrar al actualizar una inversión y cómo los manejarías?
- **queDecisionesImplica**: ¿Qué decisiones implica refactorizar el código siguiendo principios de código limpio?

## Criterios de Evaluacion

- Implementar funcionalidad para agregar inversiones con validaciones.
- Implementar funcionalidad para actualizar inversiones con validaciones.
- Implementar funcionalidad para eliminar inversiones.
- Refactorizar el código siguiendo principios de código limpio.
- Optimizar las funcionalidades para mejorar el rendimiento.

---

*Reto generado automaticamente por Challenge Generator - Pragma*
