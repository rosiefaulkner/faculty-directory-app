package com.faculty.faculty

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
class FacultyMember(val category:String, val userName:String, val middleName:String, val degree:String, val firstName:String, val lastName:String, val title:String, val bio:String, val website:String) : Parcelable {
    /**
     * Companion object for the FacultyMember class.
     */
    companion object {
        val FACULTY_KEY = "faculty"
        val CATEGORY_KEY = "category"
        val USERNAME_KEY = "userName"
        val MIDDLENAME_KEY = "middleName"
        val DEGREE_KEY = "degree"
        val FIRSTNAME_KEY = "firstName"
        val LASTNAME_KEY = "lastName"
        val TITLE_KEY = "title"
        val BIO_KEY = "bio"
        val WEBSITE_KEY = "website"
    }

    /**
     * Returns a string representation of the FacultyMember object.
     *
     * @return A string representation of the FacultyMember object.
     */
    override fun toString(): String {
        return "FacultyMember(category='$category', userName='$userName', middleName='$middleName', degree='$degree', firstName='$firstName', lastName='$lastName', title='$title', bio='$bio', website='$website')"
    }
}
