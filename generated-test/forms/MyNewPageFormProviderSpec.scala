package forms

import forms.behaviours.OptionFieldBehaviours
import models.MyNewPage
import play.api.data.FormError

class MyNewPageFormProviderSpec extends OptionFieldBehaviours {

  val form = new MyNewPageFormProvider()()

  ".value" must {

    val fieldName = "value"
    val requiredKey = "myNewPage.error.required"

    behave like optionsField[MyNewPage](
      form,
      fieldName,
      validValues  = MyNewPage.values,
      invalidError = FormError(fieldName, "error.invalid")
    )

    behave like mandatoryField(
      form,
      fieldName,
      requiredError = FormError(fieldName, requiredKey)
    )
  }
}
