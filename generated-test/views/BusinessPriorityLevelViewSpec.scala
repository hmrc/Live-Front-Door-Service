package views

import forms.BusinessPriorityLevelFormProvider
import models.{NormalMode, BusinessPriorityLevel}
import play.api.data.Form
import play.twirl.api.HtmlFormat
import views.behaviours.ViewBehaviours
import views.html.BusinessPriorityLevelView

class BusinessPriorityLevelViewSpec extends ViewBehaviours {

  val messageKeyPrefix = "businessPriorityLevel"

  val form = new BusinessPriorityLevelFormProvider()()

  val view = viewFor[BusinessPriorityLevelView](Some(emptyUserAnswers))

  def applyView(form: Form[_]): HtmlFormat.Appendable =
    view.apply(form, NormalMode)(fakeRequest, messages)

  "BusinessPriorityLevelView" must {

    behave like normalPage(applyView(form), messageKeyPrefix)

    behave like pageWithBackLink(applyView(form))
  }

  "BusinessPriorityLevelView" when {

    "rendered" must {

      "contain radio buttons for the value" in {

        val doc = asDocument(applyView(form))

        for (option <- BusinessPriorityLevel.options) {
          assertContainsRadioButton(doc, option.id, "value", option.value, false)
        }
      }
    }

    for (option <- BusinessPriorityLevel.options) {

      s"rendered with a value of '${option.value}'" must {

        s"have the '${option.value}' radio button selected" in {

          val doc = asDocument(applyView(form.bind(Map("value" -> s"${option.value}"))))

          assertContainsRadioButton(doc, option.id, "value", option.value, true)

          for (unselectedOption <- BusinessPriorityLevel.options.filterNot(o => o == option)) {
            assertContainsRadioButton(doc, unselectedOption.id, "value", unselectedOption.value, false)
          }
        }
      }
    }
  }
}
