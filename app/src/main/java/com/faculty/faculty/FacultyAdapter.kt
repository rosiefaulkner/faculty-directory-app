package com.faculty.faculty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.faculty.faculty.R.*

class FacultyAdapter(
    private val facultyMembers: ArrayList<FacultyMember>,
    private val listener: (FacultyMember) -> Unit
) : RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder>() {

    /**
     * ViewHolder for the FacultyAdapter.
     *
     * @param itemView The view for the item.
     *
     * @return A new FacultyViewHolder.
     */
    class FacultyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val facultyImageView: ImageView = itemView.findViewById(id.facultyMemberImageView)
        private val facultyFullNameTextView: TextView = itemView.findViewById(id.facultyMemberFullNameTextView)
        private val facultyDegreeTextView: TextView = itemView.findViewById(id.facultyMemberDegreeTextView)
        private val facultyTitleTextView: TextView = itemView.findViewById(id.facultyMemberTitleTextView)
        private val facultyWebsiteTextView: TextView = itemView.findViewById(id.facultyMemberWebsiteTextView)

        /**
         * Binds the data to the ViewHolder.
         *
         * @param facultyMember The FacultyMember object to bind.
         * @param listener The click listener for the item view.
         *
         * @return A new FacultyViewHolder.
         */
        fun bind(facultyMember: FacultyMember, listener: (FacultyMember) -> Unit) {
            // Set image username
            val imageName = facultyMember.userName
            val imageId = itemView.context.resources.getIdentifier(imageName, "drawable", itemView.context.packageName)
            facultyImageView.setImageResource(imageId)

            // Concatenate first and last name with a comma before degree value
            facultyFullNameTextView.text =
                itemView.context.getString(R.string.faculty_full_name, facultyMember.firstName, facultyMember.lastName)
            facultyDegreeTextView.text = facultyMember.degree
            facultyTitleTextView.text = facultyMember.title
            facultyWebsiteTextView.text =
                itemView.context.getString(R.string.faculty_email, facultyMember.website)
            itemView.setOnClickListener {
                listener(facultyMember)
            }
        }
    }

    /**
     * Creates a new ViewHolder for the RecyclerView.
     *
     * @param parent The parent ViewGroup.
     * @param viewType The view type of the new View.
     *
     * @return A new FacultyViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val newView = inflater.inflate(layout.faculty_list_item, parent, false)
        return FacultyViewHolder(newView)
    }

    /**
     * Binds the data to the ViewHolder at the specified position.
     *
     * @param holder The ViewHolder to bind the data to.
     * @param position The position of the item in the data set.
     *
     * @return A new FacultyViewHolder.
     */
    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) {
        val facultyMember = facultyMembers[position]
        holder.bind(facultyMember, listener)
    }

    /**
     * Returns the number of items in the data set.
     *
     * @return The number of items in the data set.
     */
    override fun getItemCount(): Int = facultyMembers.size
}
