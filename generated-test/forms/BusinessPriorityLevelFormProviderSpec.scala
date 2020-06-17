package forms

import forms.behaviours.OptionFieldBehaviours
import models.BusinessPriorityLevel
import play.api.data.FormError

class BusinessPriorityLevelFormProviderSpec extends OptionFieldBehaviours {

  val form = new BusinessPriorityLevelFormProvider()()

  ".value" must {

    val fieldName = "value"
    val requiredKey = "businessPriorityLevel.error.required"

    behave like optionsField[BusinessPriorityLevel](
      form,
      fieldName,
      validValues  = BusinessPriorityLevel.values,
      invalidError = FormError(fieldName, "error.invalid")
    )

    behave like mandatoryField(
      form,
      fieldName,
      requiredError = FormError(fieldName, requiredKey)
    )
  }
}
