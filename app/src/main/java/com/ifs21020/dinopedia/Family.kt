import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Family(
    var dino_images : Int,
    var dino_name: String,
    var dino_description: String,
    var dino_lifespans: String,
    var dino_characteristic: String,
    var dino_habitat: String,
    var dino_classification: String,
) : Parcelable
