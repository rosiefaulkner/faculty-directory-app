# Faculty Directory App

The Faculty Directory App is an Android application designed to display a list of faculty members with detailed information about each individual. Users can browse faculty profiles, view their bios, and navigate to their respective websites using an in-app browser.

This project demonstrates various Android development concepts, including navigation components, view binding, recycler views, custom adapters, fragments, and WebView integration.

**Faculty List**             |  **Faculty Details**   | **In-App Browser**
:-------------------------:|:-------------------------:|:-------------------------:
![](https://github.com/user-attachments/assets/4bb17fcd-2ac0-424e-9b7d-6ae3492fdd8c) |  ![](https://github.com/user-attachments/assets/77326027-9980-48aa-a818-e37c23d5e95f) | ![](https://github.com/user-attachments/assets/0e17ef52-45cf-4e6b-ab3a-ddb64756ad42)

---

## Video Walkthrough


https://github.com/user-attachments/assets/e185bf44-ddf2-47ec-972e-a61f5bb03d03


---

## Features
• Display a scrollable list of faculty members using a RecyclerView.\
• View detailed information about a faculty member, including their name, degree, title, bio, and profile picture.\
• Navigate to faculty websites within the app using a WebView.\
• Dynamic navigation with argument passing between fragments using SafeArgs.\
• Structured and modular codebase for scalability and readability.

---

## Prerequisites

To run this project, ensure you have the following:

• Android Studio Arctic Fox or a later version.\
• JDK 8 or higher.\
• Gradle 7.0 or higher.\
• An Android device or emulator running API 21 (Lollipop) or later.

---

## Setup

1. Clone the repository:

```bash
git clone https://github.com/yourusername/faculty-directory-app.git
```

2. Open the project in Android Studio.
3. Sync the project with Gradle files.
4. Run the app on an emulator or physical device.

---

## Project Structure

### Main Components

| File/Directory                | Description                                      |
|-------------------------------|--------------------------------------------------|
| `MainActivity.kt` | Hosts the navigation controller for the app. Manages the overall app lifecycle. |
| `FacultyFragment.kt` | Displays a list of faculty members in a **RecyclerView**. |
| `FacultyDetailFragment.kt` | Shows detailed information about a selected faculty member. |
| `BrowserFragment.kt` | Displays the faculty member's website in a **WebView**. |
| `FacultyAdapter.kt` | Custom adapter for binding faculty member data to **RecyclerView** items. |
| `FacultyMember.kt` | Data class representing a faculty member, implementing **Parcelable** for easy argument passing. |
| `res/layout/` | Contains XML layout files for activities, fragments, and RecyclerView items. |
| `assets/faculty_data.json`    | JSON file containing mock data for faculty members. |
| `navigation/nav_graph.xml`    | Navigation graph defining navigation between fragments. |


---

## Implementation Details

### Data Model
The `FacultyMember` class represents the faculty member entity with properties such as:

• `category`: The category of the faculty member (e.g., Professor, Assistant).\
• `userName`: A unique identifier used to map profile images.\
• `degree`, `title`, `bio`: Faculty-specific details.

The class is Parcelable, making it easy to pass between fragments.

---

## Navigation

The app uses Android's Navigation Component for seamless navigation:

• `FacultyFragment` → Displays the list of faculty members.\
• `FacultyDetailFragment` → Shows details of the selected faculty member.\
• `BrowserFragment` → Opens the faculty member's website in a WebView.\

The navigation is defined in `nav_graph.xml`, and arguments are passed using `SafeArgs`.

---

## RecyclerView

• The FacultyAdapter binds faculty data to a custom layout defined in `faculty_list_item.xml`.\
• Clicking an item navigates to the `FacultyDetailFragment`.

---

## View Binding

• View binding is used throughout the app for type-safe, boilerplate-free access to UI elements.

---

## JSON Parsing 

• Faculty data is stored in `assets/faculty_data.json`. The data is parsed in `FacultyFragment` using Android's JSONObject API.

--- 

## WebView Integration

The BrowserFragment contains a WebView that:

• Dynamically constructs a URL using the faculty member's last name.\
• Displays the website directly within the app.

---

## Running the App

1. After setting up, launch the app in an emulator or physical device.
2. Browse the list of faculty members.
3. Select a faculty member to view their details.
4. Use the "Open in Browser" button to view their website.

---

## Customization

### Updating Faculty Data

Replace `faculty_data.json` with your own JSON file, adhering to the following format:

```json
{
  "faculty": [
    {
      "category": "Professor",
      "userName": "jdoe",
      "middleName": "A",
      "degree": "Ph.D.",
      "firstName": "John",
      "lastName": "Doe",
      "title": "Senior Professor of Computer Science",
      "bio": "Dr. Doe specializes in machine learning and AI research.",
      "website": "http://example.com/jdoe"
    }
  ]
}
```

## Adding Images

Store profile images in `res/drawable` using the userName value as the filename (e.g., `jdoe.png`).

## Contributing

1. Fork the repository.
Create a feature branch:
```bash
git checkout -b feature-name
```
2. Commit your changes:
```bash
git commit -m "Add new feature"
```
3. Push to the branch:
```bash
git push origin feature-name
```
4. Open a pull request.

--- 

## License

This project is licensed under the [MIT License](https://opensource.org/license/mit).

---

Happy coding! 🚀




