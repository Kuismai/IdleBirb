package fi.oamk.idlebirb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val viewModel: MyViewModel by activityViewModels()
    val executorService = Executors.newSingleThreadScheduledExecutor()
    //private Runnable r


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        //val executorService = Executors.newSingleThreadScheduledExecutor()
        //executorService.scheduleAtFixedRate({ updateNums()}, 0, 1, TimeUnit.SECONDS)



    }

    private fun updateNums() {
        /*var babies = viewModel.babies.value!!
        var seeds = viewModel.seeds.value!!
        var multi: Int = viewModel.multiplier.value!!
        val seedc = view?.findViewById(R.id.textViewS) as TextView

        val seed1 = seeds + (babies * multi)

        viewModel.setSeeds(seed1)
        seedc.text = seed1.toString()*/

        Toast.makeText(context, "I'm running here!", Toast.LENGTH_SHORT).show()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var seeds = viewModel.seeds.value
        val seedc = view.findViewById(R.id.textViewS) as TextView
        seedc.text = seeds.toString()

        var feathers = viewModel.feathers.value
        val featherc = view.findViewById(R.id.textViewF) as TextView
        featherc.text = feathers.toString()



        val buttonSeeds = view.findViewById<Button>(R.id.button_s)
        buttonSeeds.setOnClickListener {
            gatherSeeds()
        }

        executorService.scheduleAtFixedRate({ updateNums() }, 0, 1, TimeUnit.SECONDS)
    }

    override fun onResume() {
        super.onResume()
        var seeds = viewModel.seeds.value
        val seedc = view?.findViewById(R.id.textViewS) as TextView
        seedc.text = seeds.toString()

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



fun gatherSeeds() {
    var seeds: Int = viewModel.seeds.value!!
    var multi: Int = viewModel.multiplier.value!!
    var seeds1: Int = (seeds + multi)
    viewModel.setSeeds(seeds1)
    val seedc = view?.findViewById(R.id.textViewS) as TextView
    seedc.text = seeds1.toString()
}
}