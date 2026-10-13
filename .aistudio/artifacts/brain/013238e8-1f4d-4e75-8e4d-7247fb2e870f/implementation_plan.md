# Tenoch Girón | AI & Mobile Studio — Official Google Play Developer Portal & Interactive Showcase

Portal oficial de desarrollador para verificación de identidad y cumplimiento normativo en Google Play Console, portafolio interactivo de ingeniería y ciencia de datos del Ing. Tenoch Alberto Girón Acosta, y laboratorio en vivo con demos funcionales de ChefMágico, Emociona y Bienestar CETis 23, asistido por IA Gemini.

## User Review & Critical Decisions

> [!IMPORTANT]
> **Alineación con la Verificación de Google Play Console:**
> El usuario ha confirmado que la prioridad crítica es contar con una **página web oficial de desarrollador completa y lista para verificación ante Google Play Store**, con todas las políticas obligatorias, protocolo de eliminación de cuenta/datos, soporte técnico y `app-ads.txt`.
> Se implementará una arquitectura de doble propósito: una aplicación web SPA rica, responsiva y de alto rendimiento que se aloja en el proyecto lista para ser desplegada en GitHub Pages/Firebase Hosting/Vercel, y que a la vez se ejecuta de forma nativa e inmediata en el Streaming Emulator de Android mediante un contenedor de alta velocidad con WebView edge-to-edge y aceleración por hardware.

- **Confirmado por el Usuario**: Construcción orientada a página web oficial para verificación de desarrollador en Google Play y cumplimiento de políticas normativas.
- **Demos Interactivas**: Se implementan las tres experiencias completas en vivo (ChefMágico con despensa y temporizador, Emociona con rueda afectiva y test psicométrico, y Bienestar CETis 23 con clima escolar y retención).
- **Asistente de IA Gemini**: Modo híbrido con base de conocimiento curada sobre la trayectoria académica (ESCOM-IPN, INFOTEC, DGETI) y las apps de Tenoch, respaldado con conexión a Gemini API mediante secret keys.
- **Cumplimiento Google Play**: Secciones dedicadas y exportables para Políticas de Privacidad por app, Términos de Servicio, Formulario de Eliminación de Datos (Data Safety) y especificación técnica de `app-ads.txt` para Google AdMob.

---

## 1. Overview & Core Concept

- **Qué hace**: Provee la presencia digital oficial y regulatoria requerida por Google Play Console para el desarrollador **Ing. Tenoch Alberto Girón Acosta**, exhibiendo su ecosistema de aplicaciones móviles, proyectos de investigación en IA/AIoT, trayectoria docente y académica (IPN/INFOTEC/DGETI), laboratorio interactivo con mini-demos funcionales y un centro de privacidad y soporte auditado para cumplimiento de Google Play.
- **Público Objetivo**: Revisores de políticas de Google Play Store, usuarios finales de las aplicaciones móviles, reclutadores de tecnología, directivos educativos y la comunidad estudiantil.
- **Valor Clave**: Cumple al 100% con los requisitos de verificación de identidad de Google Play (identidad real, correo oficial `tenochalbertogiron290@gmail.com`, políticas específicas por app, formulario de borrado de datos y `app-ads.txt`), eliminando el riesgo de rechazo o suspensión de aplicaciones.

---

## 2. User Experience & Visual Design

### Flujos Clave de Usuario
1. **Verificación de Identidad & Hero:** Cabecera con insignia oficial *Google Play Registered Developer*, bio profesional del Ing. Tenoch Alberto Girón Acosta, lema "Tecnología e Inteligencia Artificial con Sentido Humano", selector de idioma (Español / English) y conmutador de tema Claro/Oscuro.
2. **Ecosistema de Apps (Estilo Google Play Store):** Tarjetas con badges de categoría, clasificación "Para todos", capturas interactivas, lista transparente de permisos requeridos y botón de "Probar Demo Interactiva".
3. **Laboratorio en Vivo (Live Sandbox):**
   - *ChefMágico Demo:* Selector de ingredientes (despensa virtual), preferencias ("Rápido < 20 min", "Saludable", "Mexicano"), conmutador "Modo Lectura Grande (DUA)" y receta generada con temporizador interactivo.
   - *Emociona Demo:* Rueda de emociones multinivel con 6 núcleos, ejercicio reflexivo del Modelo ABC y test psicoeducativo de estilos de apego de 3 reactivos con cálculo de resultado.
   - *Bienestar CETis 23 Demo:* Termómetro de clima escolar grupal, simulador de factores de retención y métricas de acompañamiento tutorial.
4. **Centro de Cumplimiento Google Play:** Pestañas con la Política de Privacidad individual para cada app, Términos de Servicio, especificación de `app-ads.txt` para Google AdMob y Formulario funcional de Solicitud de Eliminación de Cuenta/Datos.
5. **Portafolio de Investigación & Trayectoria:** Visualización con filtros por área (IA, AIoT/Hidrometría, Modelado Econométrico GARCH, Humedal PAEC, Scripts Educativos) y línea de tiempo con reconocimientos (Coordinador IA CETis 23, Basificación, ESCOM-IPN, INFOTEC).
6. **Asistente Gemini Integrado:** Drawer/modal interactivo para consultar dudas técnicas sobre las apps, permisos, código y contacto del desarrollador.

### Identidad Visual & Temas
- **Estética:** *Google AI & Material You Dark Tech* (elegante, profesional y moderno).
- **Paleta de Colores:**
  - Fondo Primario Oscuro: `#0B0F19` / Fondo Secundario: `#111827` / Tarjetas: `#1F2937`
  - Modo Claro: `#F8FAFC` con tarjetas `#FFFFFF` y bordes `#E2E8F0`
  - Acentos Google AI: Azul Gemini (`#4285F4`), Violeta Spark (`#8B5CF6`), Esmeralda Android (`#34A853`), Ámbar Cálido (`#F59E0B`)
- **Tipografía:** Tipografías legibles y modernas estilo Google Sans / Roboto / Inter con soporte DUA para accesibilidad visual.
- **Efectos:** *Glassmorphism* (`backdrop-blur-md bg-white/5 border border-white/10`), micro-interacciones en botones y ripples táctiles.

---

## 3. Key Product Decisions & Trade-Offs

- **Decisión 1: Arquitectura Web Standalone con Contenedor Android Nativo**
  - *Enfoque*: Generar una aplicación web SPA completa en HTML5/Tailwind/TypeScript/Modern UI empaquetada en `app/src/main/assets/web/` y visible en el Android Emulator mediante un WebView edge-to-edge optimizado, con opción directa de exportación para hosting web externo (GitHub Pages/Vercel/Firebase).
  - *Por qué*: Satisface tanto el requerimiento de Google Play Console (sitio web accesible públicamente para verificación de identidad) como el entorno de ejecución de AI Studio (compilación Android e inspección en streaming emulator).
- **Decisión 2: Formulario de Eliminación de Cuenta y Datos (Google Play Data Deletion Requirement)**
  - *Enfoque*: Implementar un formulario interactivo con generación automática de ticket de eliminación hacia `tenochalbertogiron290@gmail.com` con identificador único, selector de tipo de borrado y acuse de recibo con compromiso de 72 horas.
  - *Por qué*: Google Play exige expresamente un enlace web público donde los usuarios puedan solicitar la eliminación de su cuenta y datos asociados sin necesidad de reinstalar la app.
- **Decisión 3: Simulador y Archivo de `app-ads.txt` para Google AdMob**
  - *Enfoque*: Sección técnica dedicada con visor de texto plano, botón de copiado de cadena de anunciante autorizado de AdMob (`google.com, pub-XXXXXXXXXXXXXXXX, DIRECT, f08c47fec0942fa0`) y archivo `app-ads.txt` listo para la raíz del dominio.
  - *Por qué*: Requisito de ingresos publicitarios e integridad de AdMob para evitar pérdidas de inventario en apps de Google Play.

---

## 4. Technical Architecture & Data Strategy

### Diagrama de Arquitectura del Sistema

```
┌────────────────────────────────────────────────────────────────────────┐
│                   TENOCH GIRÓN | AI & MOBILE STUDIO                   │
│               Official Google Play Console Developer Hub               │
└───────────────────────────────────┬────────────────────────────────────┘
                                    │
          ┌─────────────────────────┴────────────────────────┐
          ▼                                                  ▼
┌─────────────────────────────────┐        ┌─────────────────────────────────┐
│     PORTAL WEB MULTIPLATAFORMA  │        │   ANDROID COMPATIBILITY ENGINE  │
│    (HTML5 / Tailwind / JS SPA)  │        │   (Jetpack Compose + WebView)   │
├─────────────────────────────────┤        ├─────────────────────────────────┤
│ • Header (Lang ES/EN, Dark/Light)│       │ • Edge-to-Edge Safe Drawing     │
│ • Verified Developer Identity   │        │ • WebChromeClient + JS Bridge   │
│ • Google Play Apps Showcase     │        │ • URL Intent & Mailto Handlers  │
│ • Live Sandboxes (3 Demos)      │        │ • Quick Action Floating Toolbar │
│ • Research & AIoT Portfolio     │        │ • One-click URL Inspector       │
│ • Play Compliance & app-ads.txt │        │ • Offline-first Asset Loader    │
│ • Data Deletion Request Form    │        └─────────────────────────────────┘
│ • Gemini AI Interactive Chat    │
└────────────────┬────────────────┘
                 │
                 ▼
┌────────────────────────────────────────────────────────────────────────┐
│               SERVICIOS DE DATOS Y PROCESAMIENTO                       │
├────────────────────────────────┬───────────────────────────────────────┤
│ • Developer Knowledge Base     │ Biografía oficial ESCOM-IPN / INFOTEC  │
│ • Gemini API REST Service      │ gemini-3.5-flash / Offline Fallback    │
│ • Interactive State Engines    │ Recetas, Rueda Emocional, Clima Escolar│
│ • Data Deletion Dispatcher     │ Formulario validado + Mailto Generator │
│ • AdMob app-ads.txt Engine     │ Validación de dominio e IAB spec       │
└────────────────┴────────────────┘
```

### Modelo de Datos y Estados Clave
- **Estado de Navegación:** Pestaña o ancla activa (`#apps`, `#sandbox`, `#portfolio`, `#compliance`, `#privacy-chefmagico`, `#privacy-emociona`, `#privacy-cetis`, `#data-deletion`, `#app-ads`).
- **Estado de Idioma:** `es` (Español por defecto) / `en` (English para revisores internacionales de Google).
- **Estado de Tema:** `dark` (predeterminado de alta fidelidad) / `light` (fondo blanco/gris limpio).
- **Estado de Sandbox ChefMágico:** Ingredientes seleccionados (Set de IDs), tiempo de cocción, modo de lectura DUA (`boolean`), receta activa con temporizador decreciente (`secondsRemaining`, `isRunning`).
- **Estado de Sandbox Emociona:** Emoción nuclear activa (6 núcleos de Plutchik/Bisquerra), sub-emoción detallada, respuesta ABC y progreso del test psicométrico (reactivos 1 a 3 con puntaje).
- **Estado de Sandbox Bienestar CETis 23:** Indicador de clima escolar (`Excelente`, `Estable`, `Alerta`), cálculo de retención en tiempo real.
- **Estado de Eliminación de Datos:** Formulario con `appName`, `userEmail`, `deletionType` (cuenta completa vs datos específicos), ticket generado y confirmación.
- **Estado de Gemini Chat:** Historial de mensajes `[{role: 'user' | 'assistant', content: string}]`, indicador de carga y respuestas contextuales automáticas.
