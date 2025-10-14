import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.finalsetup.PaymentActivity

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            context.startActivity(Intent(context, PaymentActivity::class.java))
        }) {
            Text("Open Payment")
        }
    }
}

