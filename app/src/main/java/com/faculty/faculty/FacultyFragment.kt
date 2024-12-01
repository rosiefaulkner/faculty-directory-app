package com.faculty.faculty

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.faculty.faculty.databinding.FragmentFacultyBinding
import org.json.JSONObject

class FacultyFragment : Fragment() {
    private val facultyMembers = ArrayList<FacultyMember>()
    private lateinit var binding: FragmentFacultyBinding

    /**
     * Called when the fragment is first created.
     *
     * @param inflater Layout inflater used to inflate the view.
     * @param container Parent view group of the fragment.
     *
     * @return The view created by the fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using View Binding
        binding = FragmentFacultyBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Called when the view is created.
     *
     * @param view The view created by the fragment.
     * @param savedInstanceState The saved instance state of the fragment.
     *
     * @return The view created by the fragment.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Load faculty data from JSON file
        getFacultyMembersFromJSON()

        // Setup RecyclerView using JSON data
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = FacultyAdapter(facultyMembers) { facultyMember ->
                onFacultyItemClick(facultyMember)
            }
        }
    }

    /**
     * Called when a faculty item is clicked.
     *
     * @param facultyMember The FacultyMember object that was clicked.
     *
     * @return The view created by the fragment.
     */
    private fun onFacultyItemClick(facultyMember: FacultyMember) {
        Log.d("FacultyFragment", "Faculty clicked: ${facultyMember.firstName} ${facultyMember.lastName}")
        // Navigate to FacultyDetailFragment and pass it, which is the faculty member object

        val action = FacultyFragmentDirections.showDetailFragment(facultyMember)
        Navigation.findNavController(binding.root).navigate(action)
    }

    /**
     * Loads faculty data from a JSON file.
     *
     * @return The view created by the fragment.
     * @throws Exception If there is an error reading the JSON file.
     */
    private fun getFacultyMembersFromJSON() {
        // Ensure array is empty before attempting to add values
        facultyMembers.clear()
        try {
            val jsonString = requireActivity().assets.open("faculty_data.json").bufferedReader().use { it.readText() }
            val jsonResponse = JSONObject(jsonString)
            val facultyArray = jsonResponse.getJSONArray(FacultyMember.FACULTY_KEY)

            for (i in 0 until facultyArray.length()) {
                val facultyObject = facultyArray.getJSONObject(i)
                val facultyMember = FacultyMember(
                    category = facultyObject.getString(FacultyMember.CATEGORY_KEY),
                    userName = facultyObject.getString(FacultyMember.USERNAME_KEY),
                    middleName = facultyObject.getString(FacultyMember.MIDDLENAME_KEY),
                    degree = facultyObject.getString(FacultyMember.DEGREE_KEY),
                    firstName = facultyObject.getString(FacultyMember.FIRSTNAME_KEY),
                    lastName = facultyObject.getString(FacultyMember.LASTNAME_KEY),
                    title = facultyObject.getString(FacultyMember.TITLE_KEY),
                    bio = facultyObject.getString(FacultyMember.BIO_KEY),
                    website = facultyObject.getString(FacultyMember.WEBSITE_KEY)
                )
                facultyMembers.add(facultyMember)
            }
        } catch (ex: Exception) {
            Log.e("FacultyFragment", "Error reading JSON", ex)
        }
    }
}
