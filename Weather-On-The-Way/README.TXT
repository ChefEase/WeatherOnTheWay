PROJECT TITLE: Weather On The Way

PURPOSE OF PROJECT:
Plan a multi-city trip and show weather conditions for each city at the
expected arrival time. The project is a JavaFX desktop application built
as a BlueJ-compatible project (default package, plain .java files).

VERSION or DATE:
CS 2043 - Fall 2026, Group 4
Approved design: FinalClassDiagram.pdf (repository root)

HOW TO START THIS PROJECT:
1. Open the Weather-On-The-Way folder in BlueJ.
2. Use a JDK that includes JavaFX, or add the JavaFX SDK to BlueJ's user
   libraries.
3. Run MainApp.
The domain classes are created by the other team members. This branch owns
the initial JavaFX window, the trip-creation UI, and the add-stops UI.

AUTHORS:
Group 4

USER INSTRUCTIONS:
- Start the application and choose "New Trip".
- Enter the trip name, start city, destination city, travel duration,
  time-zone difference, and variability.
- Add intermediate stops, then create/save the trip.
- The UI talks only to Coordinator. It must not call Trip, City, Schedule,
  RouteSegment, ForecastPlan, or WeatherService directly.

IMPLEMENTATION NOTES:
- Follow FinalClassDiagram.pdf exactly. Subm4_solution.pdf and the marking
  schema are reference material only.
- See ../README.md for the full class contract, Coordinator interaction
  points, known diagram gaps, and the incremental plan.
