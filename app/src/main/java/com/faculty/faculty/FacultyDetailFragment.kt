package com.faculty.faculty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.faculty.faculty.databinding.FragmentFacultyDetailBinding

class FacultyDetailFragment : Fragment() {
    lateinit var binding: FragmentFacultyDetailBinding

    /**
     * Called when the fragment is first created.
     *
     * @param savedInstanceState The saved instance state of the fragment.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param inflater LayoutInflater used to inflate the view.
     * @param savedInstanceState The saved instance state of the fragment.
     *
     * @return The view created by the fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFacultyDetailBinding.inflate(inflater, container, false)
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
        val args = FacultyDetailFragmentArgs.fromBundle(requireArguments())
        val facultyMember = args.facultyMember
        if (arguments != null) {
            binding.facultyMemberFullNameTextView.text = formatFullName(facultyMember.firstName, facultyMember.middleName, facultyMember.lastName)
            binding.facultyMemberDegreeTextView.text = facultyMember.degree
            binding.facultyMemberTitleTextView.text = facultyMember.title
            binding.facultyMemberBioTextView.text = facultyMember.bio
            val imageId = resources.getIdentifier(facultyMember.userName, "drawable", requireContext().packageName)
            binding.facultyMemberImageView.setImageResource(imageId)
        }
        binding.browserButton.setOnClickListener {
            val action = FacultyDetailFragmentDirections.showBrowserFragment(facultyMember.lastName)
            Navigation.findNavController(view).navigate(action)
        }
    }

    /**
     * Formats the full name of the faculty member.
     *
     * @param firstName The first name of the faculty member.
     * @param middleName The middle name of the faculty member.
     * @param lastName The last name of the faculty member.
     *
     * @return The formatted full name of the faculty member.
     */
    private fun formatFullName(firstName: String, middleName: String, lastName: String): String {
        // If middle name is not empty, append a period. Else, append nothing.
        val formattedMiddleName = if (middleName.isNotEmpty()) "$middleName." else ""
        return "$firstName $formattedMiddleName $lastName"
    }
}