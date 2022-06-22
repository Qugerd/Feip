package com.example.fitnesstracker

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class RegistrationPage : Fragment(R.layout.fragment_registration_page)  {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_reg).setOnClickListener {
            findNavController().navigate(R.id.action_registrationPage_to_login)
        }

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        val textView = view.findViewById<TextView>(R.id.agreement)
        val string_agreement = SpannableString("Нажимая на кнопку, вы соглашаетесь с политикой конфиденциальности и обработки персональных данных, а также принимаете пользовательское соглашение")

        val SpanPolitic: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                Toast.makeText(view.context, "Политика конфиденциальности", Toast.LENGTH_LONG).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }

        val SpanAgree: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                Toast.makeText(view.context, "Пользовательское соглашение", Toast.LENGTH_LONG).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }

        string_agreement.setSpan(SpanPolitic, 37, 65, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        string_agreement.setSpan(SpanAgree, 118, 145, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = string_agreement
        textView.movementMethod = LinkMovementMethod.getInstance()
    }
}