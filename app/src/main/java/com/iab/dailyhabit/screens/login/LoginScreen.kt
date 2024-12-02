package com.iab.dailyhabit.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iab.dailyhabit.R
val GagalinFontFamily = FontFamily(Font(R.font.gagalin))

@Composable
fun LoginScreen() {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    // Variable de estado para cambiar el texto
    var isCreatingAccount by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            // Título
            Text(
                text = "DAILY HABIT", // Cambia el texto según el estado
                fontSize = 32.sp,
                fontFamily = GagalinFontFamily,
                color = Color.White,
                modifier = Modifier.padding(top = 48.dp)
            )

            // Imagen del logo
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .padding(16.dp)
                    .background(Color.Gray, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dailyhabitlogo), // Cambia "logo" por el nombre de tu recurso
                    contentDescription = "App Logo",
                    modifier = Modifier.size(100.dp)
                )
            }

            // Caja para el formulario
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .background(Color(0xFF2B2B2B), shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Column {
                    // Campo de correo electrónico
                    OutlinedTextField(
                        value = email.value,
                        onValueChange = { email.value = it },
                        label = { Text("Email", color = Color.Gray) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Email Icon",
                                tint = Color.Gray
                            )
                        },
                        textStyle = TextStyle(color = Color.White),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        singleLine = true,
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedLabelColor = Color.Gray,
                            focusedLabelColor = Color.White,
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color.Gray
                        )
                    )

                    // Campo de contraseña
                    OutlinedTextField(
                        value = password.value,
                        onValueChange = { password.value = it },
                        label = { Text("Password", color = Color.Gray) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Password Icon",
                                tint = Color.Gray
                            )
                        },
                        textStyle = TextStyle(color = Color.White),
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        singleLine = true,
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedLabelColor = Color.Gray,
                            focusedLabelColor = Color.White,
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color.Gray
                        )
                    )

                    Button(
                        onClick = { /* Acción de login */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = if (isCreatingAccount) "Sign Up" else "Login", // Cambia el texto del botón
                            color = Color.White
                        )
                    }
                }
            }

            // Texto para crear cuenta
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = if (isCreatingAccount) "Already have an account?" else "Don't have an account?",
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = if (isCreatingAccount) "Sign in" else "Create an account",
                    color = Color(0xFFFF9800),
                    modifier = Modifier.clickable { isCreatingAccount = !isCreatingAccount } // Cambia el estado al hacer clic
                )
            }

            // Botón de Google Login
            Button(
                onClick = { /* Acción de login con Google */ },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(48.dp)
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Aquí reemplazamos el ícono por un recurso de imagen
                    Image(
                        painter = painterResource(id = R.drawable.google_icon), // Reemplaza "google_icon" con el nombre de tu recurso
                        contentDescription = "Google Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Login with Google",
                        color = Color.White
                    )
                }
            }
        }
    }
}