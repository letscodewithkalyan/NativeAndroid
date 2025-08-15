package com.kp.composearc.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Preview
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComposeComponents() {
    var textField by remember { mutableStateOf("") }
    var outlineText by remember { mutableStateOf("") }
    var basicText by remember { mutableStateOf("") }
    var switchChecked by remember { mutableStateOf(false) }
    var checkBoxChecked by remember { mutableStateOf(false) }
    var radioSelection by remember { mutableStateOf("Option 1") }
    var triState by remember { mutableStateOf(ToggleableState.Indeterminate) }

    Column(
        modifier = Modifier
            .padding(WindowInsets.safeDrawing.asPaddingValues())
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Button(modifier = Modifier.fillMaxWidth(), onClick = {}) {
            Text("Button")
        }
        OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = {}) {
            Text("OutlineButton")
        }
        TextButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text("Text Button")
        }
        IconButton(onClick = {}, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Icon(Icons.Filled.Delete, contentDescription = "delete")
        }
        FilledIconButton(onClick = {}, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Icon(Icons.Filled.Preview, contentDescription = "click")
        }
        OutlinedIconButton(onClick = {}, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Icon(Icons.Filled.Person, contentDescription = "person")
        }
        TextField(
            value = textField,
            onValueChange = { textField = it },
            label = { Text("TextField") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = outlineText,
            onValueChange = { textField = it },
            label = { Text("Outline Textfield") },
            modifier = Modifier.fillMaxWidth()
        )
        BasicTextField(
            value = basicText,
            onValueChange = { basicText = it },
            decorationBox = { innerTextField ->
                if (basicText.isEmpty()) {
                    Text("Basic Text field", color = Color.Gray)
                }
                innerTextField() // The actual editable text
            }
        )
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontSize = 20.sp, color = Color.Green)) {
                append("Hello")
            }
            withStyle(style = SpanStyle(fontSize = 30.sp, color = Color.Blue)) {
                append("World!")
            }
        })
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Switch", fontSize = 18.sp)
            Switch(checked = switchChecked, onCheckedChange = { switchChecked = it })
        }
       Row(modifier = Modifier.fillMaxWidth(),
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceBetween) {
           Text("CheckBox")
           Checkbox(checked = checkBoxChecked, onCheckedChange = {checkBoxChecked = it})
       }
        Column {
            Text("Radio Buttons")
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = radioSelection == "Option 1",
                    onClick = { radioSelection = "Option 1" })
                Text("Option 1")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = radioSelection == "Option 2",
                    onClick = { radioSelection = "Option 2" })
                Text("Option 2")
            }
        }
        // TriStateCheckbox
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Trie State Checkbox")
            TriStateCheckbox(
                state = triState,
                onClick = {
                    triState = when(triState){
                        ToggleableState.On -> ToggleableState.Indeterminate
                        ToggleableState.Off -> ToggleableState.On
                        ToggleableState.Indeterminate ->  ToggleableState.Off
                    }
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ComposeComponentsPreview() {
    ComposeComponents()
}