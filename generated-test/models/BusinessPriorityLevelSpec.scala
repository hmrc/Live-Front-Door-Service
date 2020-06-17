package models

import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.{MustMatchers, OptionValues, WordSpec}
import play.api.libs.json.{JsError, JsString, Json}

class BusinessPriorityLevelSpec extends WordSpec with MustMatchers with ScalaCheckPropertyChecks with OptionValues {

  "BusinessPriorityLevel" must {

    "deserialise valid values" in {

      val gen = Gen.oneOf(BusinessPriorityLevel.values.toSeq)

      forAll(gen) {
        businessPriorityLevel =>

          JsString(businessPriorityLevel.toString).validate[BusinessPriorityLevel].asOpt.value mustEqual businessPriorityLevel
      }
    }

    "fail to deserialise invalid values" in {

      val gen = arbitrary[String] suchThat (!BusinessPriorityLevel.values.map(_.toString).contains(_))

      forAll(gen) {
        invalidValue =>

          JsString(invalidValue).validate[BusinessPriorityLevel] mustEqual JsError("error.invalid")
      }
    }

    "serialise" in {

      val gen = Gen.oneOf(BusinessPriorityLevel.values.toSeq)

      forAll(gen) {
        businessPriorityLevel =>

          Json.toJson(businessPriorityLevel) mustEqual JsString(businessPriorityLevel.toString)
      }
    }
  }
}
