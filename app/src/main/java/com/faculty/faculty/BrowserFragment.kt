package com.faculty.faculty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.faculty.faculty.databinding.FragmentBrowserBinding

class BrowserFragment : Fragment() {
    lateinit var binding: FragmentBrowserBinding
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
        binding = FragmentBrowserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val args = BrowserFragmentArgs.fromBundle(it)
            val lastName = args.facultyMemberLastName
            val lastNameLower = lastName.lowercase()
            val facultyMemberWebsite = getString(R.string.faculty_website, lastNameLower)
            binding.webView.webViewClient = WebViewClient()
            binding.webView.loadUrl(facultyMemberWebsite)
        }
    }
}