import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dinosaur(
    var dinos_image : Int,
    var dinos_name : String,
    var dinos_desc : String,
    var dinos_characteristic : String,
    var dinos_kelompok : String,
    var dinos_habitat : String,
    var dinos_makanan : String,
    var dinos_panjang : String,
    var dinos_tinggi : String,
    var dinos_bobot : String,
    var dinos_kelemahan : String,
) : Parcelable
