package trpl.nim234311050.utsprofileapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import trpl.nim234311050.utsprofileapp.data.User
import trpl.nim234311050.utsprofileapp.viewmodel.UserViewModel

@Composable
fun RegisterScreen(
    viewModel: UserViewModel,
    onRegisterSuccess: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "CREATE AN ACCOUNT",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Name
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_dialog_info),
                    contentDescription = "Name Icon"
                )
            }
        )

        // Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_dialog_email),
                    contentDescription = "Email Icon"
                )
            }
        )

        // Password
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_lock_idle_lock),
                    contentDescription = "Password Icon"
                )
            }
        )

        // Phone
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = android.R.drawable.stat_sys_speakerphone),
                    contentDescription = "Phone Icon"
                )
            }
        )

        // Address
        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_dialog_map),
                    contentDescription = "Address Icon"
                )
            }
        )

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        Button(
            onClick = {
                if (name.isBlank() || email.isBlank() || password.isBlank() || phone.isBlank() || address.isBlank()) {
                    errorMessage = "Please fill all the fields"
                } else {
                    viewModel.register(User(email, name, password, phone, address))
                    onRegisterSuccess()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(28.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A90E2))
        ) {
            Text("Register", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        val annotatedString = buildAnnotatedString {
            withStyle(SpanStyle(color = Color.Gray)) { append("Already have an account? ") }
            withStyle(SpanStyle(color = Color(0xFF4A90E2), fontWeight = FontWeight.Bold)) { append("Login") }
        }

        ClickableText(
            text = annotatedString,
            onClick = { onNavigateToLogin() },
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.bodySmall.copy(textAlign = TextAlign.Center)
        )
    }
}
