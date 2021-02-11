package com.example.katatakima

import android.util.Log

class Utils {

    companion object{
        private fun isInf(currentVal:Int, beforeVal :Int): Boolean{
            if(currentVal > beforeVal){
                return true;
            }
            return false;
        }

        fun result(currentVal: Int, beforeVal: Int  ): Int{
            return if(beforeVal == 0){
                currentVal
            }else{
                if(isInf(currentVal ,beforeVal) ){
                    if(isPower10(beforeVal)) {
                        (currentVal - beforeVal) - beforeVal
                    }else{
                        -1;
                    }
                }else{
                    currentVal ;
                }

            }
        }
        private fun isPower10(value : Int): Boolean {
            var copyValue = value

            while (copyValue >=10){
                if(copyValue % 10 != 0){
                    return false;
                }
                copyValue /= 10;

            }
            if(copyValue == 1){
                return true;
            }
            return false;

        }

        fun calculateResult(strValue:String): Int{
            val charArray = strValue.toCharArray()
            var total = 0
            var beforeVal : Int ? = null
            var isSameLetterCounter = 0


            if(charArray.size == 1){
                return GrequeLetter.valueOf(charArray[0].toString()).value
            }
            for (char in charArray){
                val currentValue = GrequeLetter.valueOf(char.toString()).value

                val result = result(currentValue, beforeVal ?: 0)

                beforeVal?.let {
                    if(beforeVal == currentValue){
                        if(isSameLetterCounter < 3 && isPower10(it)){
                            isSameLetterCounter ++;
                        }else{
                            return  -1
                        }
                    }
                }
                if(result == -1){
                    return  -1
                }else{
                    total += result
                }
                beforeVal = currentValue


            }

            return  total
        }


    }

}