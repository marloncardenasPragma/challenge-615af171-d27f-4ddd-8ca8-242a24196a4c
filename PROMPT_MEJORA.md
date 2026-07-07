# Prompt para Mejorar el Codigo Base

Copia y pega el siguiente contenido completo en un asistente de IA (Claude, ChatGPT, etc.)
para obtener un ZIP con el proyecto corregido y listo para compilar.

---

```
Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación o descripciones sin código, genera los archivos
correspondientes sin aplicar análisis de compilación
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:
// === ARCHIVO: src/main/java/com/example/investment/Investment.java ===
package com.example.investment;

public class Investment {
    private String id;
    private String name;
    private double value;
    private String acquisitionDate;
    private String type;

    public Investment(String id, String name, double value, String acquisitionDate, String type) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.acquisitionDate = acquisitionDate;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

// === ARCHIVO: src/main/java/com/example/investment/application/InvestmentService.java ===
package com.example.investment.application;

import com.example.investment.Investment;
import com.example.investment.domain.InvestmentValidator;
import com.example.investment.infrastructure.InvestmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentService {
    private final InvestmentRepository investmentRepository;
    private final InvestmentValidator investmentValidator;

    public InvestmentService(InvestmentRepository investmentRepository, InvestmentValidator investmentValidator) {
        this.investmentRepository = investmentRepository;
        this.investmentValidator = investmentValidator;
    }

    public Investment addInvestment(Investment investment) {
        investmentValidator.validate(investment);
        return investmentRepository.save(investment);
    }

    public Investment updateInvestment(Investment investment) {
        investmentValidator.validate(investment);
        return investmentRepository.save(investment);
    }

    public void deleteInvestment(String id) {
        investmentRepository.deleteById(id);
    }

    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }
}

// === ARCHIVO: src/main/java/com/example/investment/domain/InvestmentValidator.java ===
package com.example.investment.domain;

import com.example.investment.Investment;
import com.example.investment.infrastructure.InvestmentRepository;

import java.util.List;

public class InvestmentValidator {
    private final InvestmentRepository investmentRepository;

    public InvestmentValidator(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public void validate(Investment investment) {
        if (investment.getValue() <= 0) {
            throw new IllegalArgumentException("El valor de la inversión debe ser positivo.");
        }
        List<Investment> existingInvestments = investmentRepository.findByName(investment.getName());
        if (!existingInvestments.isEmpty()) {
            throw new IllegalArgumentException("Ya existe una inversión con el mismo nombre.");
        }
    }
}

// === ARCHIVO: src/main/java/com/example/investment/infrastructure/InvestmentRepository.java ===
package com.example.investment.infrastructure;

import com.example.investment.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, String> {
    List<Investment> findByName(String name);
}

// === ARCHIVO: src/main/resources/application.yml ===
server:
  port: 8080

spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driverClassName: org.h2.Driver
    username: sa
    password:
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    show-sql: true
    hibernate:
      ddl-auto: create-drop

// === ARCHIVO: src/test/java/com/example/investment/InvestmentServiceTest.java ===
package com.example.investment;

import com.example.investment.application.InvestmentService;
import com.example.investment.domain.InvestmentValidator;
import com.example.investment.infrastructure.InvestmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class InvestmentServiceTest {

    @Mock
    private InvestmentRepository investmentRepository;

    @Mock
    private InvestmentValidator investmentValidator;

    @InjectMocks
    private InvestmentService investmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddInvestment() {
        Investment investment = new Investment("1", "Inversion 1", 1000.0, "2024-06-01", "Tipo 1");
        when(investmentRepository.save(investment)).thenReturn(investment);
        Investment result = investmentService.addInvestment(investment);
        assertNotNull(result);
        assertEquals(investment, result);
        verify(investmentRepository, times(1)).save(investment);
    }

    @Test
    void testUpdateInvestment() {
        Investment investment = new Investment("1", "Inversion 1", 1000.0, "2024-06-01", "Tipo 1");
        when(investmentRepository.save(investment)).thenReturn(investment);
        Investment result = investmentService.updateInvestment(investment);
        assertNotNull(result);
        assertEquals(investment, result);
        verify(investmentRepository, times(1)).save(investment);
    }

    @Test
    void testDeleteInvestment() {
        investmentService.deleteInvestment("1");
        verify(investmentRepository, times(1)).deleteById("1");
    }

    @Test
    void testGetAllInvestments() {
        when(investmentRepository.findAll()).thenReturn(Collections.emptyList());
        List<Investment> result = investmentService.getAllInvestments();
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(investmentRepository, times(1)).findAll();
    }
}

```
