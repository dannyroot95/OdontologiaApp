package com.aukde.clinica.Domain.Auth

import android.widget.Toast
import com.aukde.clinica.Domain.Network
import com.aukde.clinica.UI.Credentials.LoginActivity
import com.aukde.clinica.Utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.QueryDocumentSnapshot

class AuthProvider {

    fun login(activity : LoginActivity , dni : String ,password : String){

        var count = 0

        Network().firestore().collection(Constants.USERS).whereEqualTo("dni",dni).get().addOnSuccessListener { document ->

            if(document != null){
                for (Query : QueryDocumentSnapshot in document){
                    if (Query.exists()){
                        count++
                        val typeUser = Query.data["type_user"].toString()
                        val email = Query.data["email"].toString()
                        if(typeUser == Constants.PATIENT){
                            Toast.makeText(activity, "Usted es paciente!",Toast.LENGTH_SHORT).show()

                            //UNA VEZ VALIDADO SI ES USUARIO ES PACIENTE , REALIZAR LA AUTENTICACIÓN

                        }else{
                            Toast.makeText(activity, "Usuario no permitido!",Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(activity, "Error!",Toast.LENGTH_SHORT).show()
                    }
                }
                if (count == 0){
                    Toast.makeText(activity, "No existe este usuario!",Toast.LENGTH_SHORT).show()
                }
            }
        }.addOnCanceledListener {
            Toast.makeText(activity, "Error!",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(activity, "Error!",Toast.LENGTH_SHORT).show()
        }
    }

    fun getCurrentUserID(): String {
        // An Instance of currentUser using FirebaseAuth
        val currentUser = FirebaseAuth.getInstance().currentUser

        // A variable to assign the currentUserId if it is not null or else it will be blank.
        var currentUserID = ""
        if (currentUser != null) {
            currentUserID = currentUser.uid
        }
        return currentUserID
    }

}