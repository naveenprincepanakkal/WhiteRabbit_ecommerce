package poc.naveen.ecommerce.utils

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import java.io.IOException

class Helper {

    companion object {

        fun getJsonDataFromAsset(context: Context?, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context!!.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (exception: Exception) {
                exception.printStackTrace()
                return null
            }
            return jsonString
        }

        /**
         * Progress bar
         */
        fun getProgressDrawable(context: Context): CircularProgressDrawable {
            return CircularProgressDrawable(context).apply {
                strokeWidth = 7f
                centerRadius = 35f
                start()
            }
        }

    }
}