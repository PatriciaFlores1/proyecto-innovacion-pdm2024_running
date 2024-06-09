# RUNNING

TEMA 7: Desarrolla una aplicación que utilice el GPS para rastrear las carreras de los usuarios y proporcionar retroalimentación en tiempo real sobre su rendimiento. La aplicación puede ofrecer consejos de entrenamiento, establecer metas personalizadas y crear rutas de carrera óptimas basadas en la ubicación del usuario y sus objetivos.

## Features
1. Live tracking of running activity using GPS.
2. Tracking of user's running path in Map using Google Map Compose library.
3. Using Foreground Service, even the user closed the app and remove
   from the background, this app stills continue to track user running stats.
4. Room database to store and manage running statistics.
5. Handling nested navigation, Deep linking, conditional navigation to on
   boarding screen using Jetpack Navigation Component.
6. New Jetpack Compose image picker - helps to pick image
   without any permission.
7. Paging3 integration.
8. Dynamic color support in dark and light theme.

## Package Structure

* `core`
    * `data`: Contains entity and database related classes.
    * `tracking`: Classes that handles tracking.
* `di` : Hilt Modules.
* `domain`: Common use cases.
* `ui`
    * `nav`: Contains app navigation and destinations.
    * `screen`: Contains UI.
    * `theme`: Material3 theme.
    * `utils`: UI utility classes and common components.
* `utils`: Utility class used across the app.

## Installation

Simple clone this app and open in Android Studio.

### Google Map Integration

Do these steps if you want to show google maps. The tracking
functionalities will work as usual even if you don't do
these step.

1. Create and Get Google Maps API key by using this official
   [guide](https://developers.google.com/maps/documentation/android-sdk/get-api-key)
2. Open `local.properties` file.
3. Enter your API key like this:

```
MAPS_API_KEY=your_maps_api_key
```

## Project Status

These features are left to be implemented:

1. Show user running statistics on a chart.
2. Profile menu implementation.
3. Unit Tests
