package fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Intents
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uts_botnavrecview.*


class CharacterFrag : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: CharactersAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var charArrayList: ArrayList<Characters>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvChar)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharactersAdapter(charArrayList){
        val intent = Intent(context,DetailCharacterActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        charArrayList = arrayListOf<Characters>()

        image = arrayOf(
            R.drawable.indonesia,
            R.drawable.malaysia,
            R.drawable.thailand,
            R.drawable.vietnam,
            R.drawable.singapura,
            R.drawable.filipina,
            R.drawable.laos,
            R.drawable.brunei,
            R.drawable.kamboja,
            R.drawable.timorleste,
        )

        title = arrayOf(
            getString(R.string.indonesia),
            getString(R.string.malaysia),
            getString(R.string.thailand),
            getString(R.string.vietnam),
            getString(R.string.singapura),
            getString(R.string.filipina),
            getString(R.string.laos),
            getString(R.string.brunei),
            getString(R.string.kamboja),
            getString(R.string.timorleste),

        )
        description = arrayOf(
            getString(R.string.desc_indonesia),
            getString(R.string.desc_malaysia),
            getString(R.string.desc_thailand),
            getString(R.string.desc_vietnam),
            getString(R.string.desc_singapura),
            getString(R.string.desc_filipina),
            getString(R.string.desc_laos),
            getString(R.string.desc_brunei),
            getString(R.string.desc_kamboja),
            getString(R.string.desc_timorleste),
        )

        for (i in image.indices) {
            val char = Characters(image[i], title[i], description[i])
            charArrayList.add(char)
        }

    }
}
