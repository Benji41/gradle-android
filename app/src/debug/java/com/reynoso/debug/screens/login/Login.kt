package com.reynoso.debug.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.reynoso.experimentwithvariants.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(analytics: FirebaseAnalytics, navigateToHome: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        ClickableText(
            text = AnnotatedString("No tienes cuenta?, registrate"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(50.dp),
            onClick = {
                analytics.logEvent("CONFIGURACION") {
                    param("valor1", "no tiene cuenta")
                    param("valor2", "registro de nuevo usuario")
                }
            },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = Purple40
            )
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var email by remember {
            mutableStateOf(TextFieldValue())
        }
        var password by remember { mutableStateOf(TextFieldValue()) }

        Text(text = "Firebase Login", style = TextStyle(fontSize = 40.sp, color = Purple40))

        Spacer(modifier = Modifier.height(50.dp))

        TextField(
            label = { Text(text = "Correo electronico") },
            value = email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = { email = it })

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            label = { Text(text = "Contrasenia") },
            value = password,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(40.dp))

        Box(modifier = Modifier.padding(start = 40.dp, end = 40.dp)) {
            Button(
                onClick = {
                    analytics.logEvent("INICIO_DE_SESION"){
                        param("usuario",email.text)
                        param("password",password.text)
                    }
                    navigateToHome.invoke()
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Iniciar Sesion")
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        ClickableText(
            text = AnnotatedString("Olvidaste tu contrasenia?"),
            onClick = {
                      analytics.logEvent("olvido_contrasenia"){
                          param("usuario",email.text)
                      }
            },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                color = Purple40
            )
        )


    }
}
