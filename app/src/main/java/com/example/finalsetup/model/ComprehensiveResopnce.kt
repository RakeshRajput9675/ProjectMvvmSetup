package com.example.finalsetup.model

import com.google.gson.annotations.SerializedName


data class ComprehensiveResopnce(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Boolean?
) {
    data class Data(
        @SerializedName("add_platformby")
        val addPlatformby: Int?,
        @SerializedName("add_to_wish_list")
        val addToWishList: Any?,
        @SerializedName("admin_approved")
        val adminApproved: String?,
        @SerializedName("base_caliber")
        val baseCaliber: String?,
        @SerializedName("Bazel_material")
        val bazelMaterial: Any?,
        @SerializedName("bazel_material_data")
        val bazelMaterialData: Any?,
        @SerializedName("bracelet_color")
        val braceletColor: BraceletColor?,
        @SerializedName("bracelet_color_id")
        val braceletColorId: Int?,
        @SerializedName("bracelet_length_longside")
        val braceletLengthLongside: Any?,
        @SerializedName("bracelet_length_shortside")
        val braceletLengthShortside: Any?,
        @SerializedName("bracelet_material")
        val braceletMaterial: BraceletMaterial?,
        @SerializedName("bracelet_material_id")
        val braceletMaterialId: Int?,
        @SerializedName("bracelet_thickness")
        val braceletThickness: Any?,
        @SerializedName("brand_id")
        val brandId: Int?,
        @SerializedName("brand_name")
        val brandName: BrandName?,
        @SerializedName("buckle_width")
        val buckleWidth: Any?,
        @SerializedName("caliber_movement")
        val caliberMovement: String?,
        @SerializedName("case_diameter_max")
        val caseDiameterMax: String?,
        @SerializedName("case_diameter_min")
        val caseDiameterMin: String?,
        @SerializedName("case_material")
        val caseMaterial: CaseMaterial?,
        @SerializedName("case_material_id")
        val caseMaterialId: Int?,
        @SerializedName("category")
        val category: Int?,
        @SerializedName("clasp_material")
        val claspMaterial: Any?,
        @SerializedName("created_at")
        val createdAt: String?,
        @SerializedName("crystal_type")
        val crystalType: Any?,
        @SerializedName("currency")
        val currency: Any?,
        @SerializedName("currency_id")
        val currencyId: Int?,
        @SerializedName("dealer_currency")
        val dealerCurrency: DealerCurrency?,
        @SerializedName("description")
        val description: String?,
        @SerializedName("dial_color_id")
        val dialColorId: Int?,
        @SerializedName("dial_colour")
        val dialColour: DialColour?,
        @SerializedName("dial_number")
        val dialNumber: Any?,
        @SerializedName("frequency")
        val frequency: Any?,
        @SerializedName("frequency_type")
        val frequencyType: FrequencyType?,
        @SerializedName("function")
        val function: List<Any?>?,
        @SerializedName("gender")
        val gender: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("is_completed")
        val isCompleted: String?,
        @SerializedName("lug_width")
        val lugWidth: Any?,
        @SerializedName("model_number")
        val modelNumber: String?,
        @SerializedName("movement_type_id")
        val movementTypeId: Int?,
        @SerializedName("number_of_jewels")
        val numberOfJewels: String?,
        @SerializedName("others")
        val others: List<Any?>?,
        @SerializedName("power_reserve")
        val powerReserve: Any?,
        @SerializedName("price")
        val price: String?,
        @SerializedName("Product_condition_type")
        val productConditionType: ProductConditionType?,
        @SerializedName("product_conditions")
        val productConditions: ProductConditions?,
        @SerializedName("product_images")
        val productImages: List<ProductImage?>?,
        @SerializedName("Product_Reviews")
        val productReviews: Any?,
        @SerializedName("reason")
        val reason: Any?,
        @SerializedName("Recommended_Products")
        val recommendedProducts: List<RecommendedProduct?>?,
        @SerializedName("refernece_number")
        val referneceNumber: String?,
        @SerializedName("scope_of_delivery")
        val scopeOfDelivery: ScopeOfDelivery?,
        @SerializedName("scope_of_delivery_id")
        val scopeOfDeliveryId: Int?,
        @SerializedName("SellerDetails")
        val sellerDetails: SellerDetails?,
        @SerializedName("serial_number")
        val serialNumber: String?,
        @SerializedName("shipment_charge")
        val shipmentCharge: ShipmentCharge?,
        @SerializedName("status")
        val status: String?,
        @SerializedName("thickness")
        val thickness: Any?,
        @SerializedName("type_of_clasp")
        val typeOfClasp: Any?,
        @SerializedName("updated_at")
        val updatedAt: String?,
        @SerializedName("user_id")
        val userId: String?,
        @SerializedName("user_type")
        val userType: String?,
        @SerializedName("watch_category")
        val watchCategory: Any?,
        @SerializedName("watch_material")
        val watchMaterial: WatchMaterial?,
        @SerializedName("Watch_type")
        val watchType: Any?,
        @SerializedName("watch_type_data")
        val watchTypeData: Any?,
        @SerializedName("watchmovement")
        val watchmovement: Watchmovement?,
        @SerializedName("water_resistance")
        val waterResistance: Any?,
        @SerializedName("year_of_production")
        val yearOfProduction: String?,
        @SerializedName("You_may_interest_product")
        val youMayInterestProduct: List<YouMayInterestProduct?>?
    ) {
        data class BraceletColor(
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("status")
            val status: String?,
            @SerializedName("updated_at")
            val updatedAt: String?
        )

        data class BraceletMaterial(
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("status")
            val status: String?,
            @SerializedName("updated_at")
            val updatedAt: String?
        )

        data class BrandName(
            @SerializedName("brand_name")
            val brandName: String?,
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("image")
            val image: String?,
            @SerializedName("status")
            val status: String?,
            @SerializedName("updated_at")
            val updatedAt: String?
        )

        data class CaseMaterial(
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("status")
            val status: String?,
            @SerializedName("updated_at")
            val updatedAt: String?
        )

        data class DealerCurrency(
            @SerializedName("created_at")
            val createdAt: Any?,
            @SerializedName("currency")
            val currency: String?,
            @SerializedName("currency_symbol")
            val currencySymbol: Any?,
            @SerializedName("dealerID")
            val dealerID: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("updated_at")
            val updatedAt: Any?
        )

        data class DialColour(
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("status")
            val status: String?,
            @SerializedName("updated_at")
            val updatedAt: String?
        )

        data class FrequencyType(
            @SerializedName("created_at")
            val createdAt: Any?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("updated_at")
            val updatedAt: Any?
        )

        data class ProductConditionType(
            @SerializedName("created_at")
            val createdAt: Any?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("updated_at")
            val updatedAt: Any?,
            @SerializedName("value")
            val value: String?
        )

        data class ProductConditions(
            @SerializedName("band_and_clasp_condition")
            val bandAndClaspCondition: String?,
            @SerializedName("bazel_condition")
            val bazelCondition: String?,
            @SerializedName("case_back_condition")
            val caseBackCondition: String?,
            @SerializedName("case_condition")
            val caseCondition: String?,
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("crystal_condition")
            val crystalCondition: String?,
            @SerializedName("dial_condition")
            val dialCondition: String?,
            @SerializedName("has_wear")
            val hasWear: Int?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("product_id")
            val productId: Int?,
            @SerializedName("updated_at")
            val updatedAt: String?
        )

        data class ProductImage(
            @SerializedName("admin_remarks")
            val adminRemarks: Any?,
            @SerializedName("after_image")
            val afterImage: Any?,
            @SerializedName("before_image")
            val beforeImage: String?,
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("image_path")
            val imagePath: String?,
            @SerializedName("image_time")
            val imageTime: String?,
            @SerializedName("image_type")
            val imageType: String?,
            @SerializedName("is_primary")
            val isPrimary: Int?,
            @SerializedName("product_id")
            val productId: Int?,
            @SerializedName("status")
            val status: String?,
            @SerializedName("updated_at")
            val updatedAt: String?
        )

        data class RecommendedProduct(
            @SerializedName("add_platformby")
            val addPlatformby: Int?,
            @SerializedName("add_to_wish_list")
            val addToWishList: AddToWishList?,
            @SerializedName("admin_approved")
            val adminApproved: String?,
            @SerializedName("base_caliber")
            val baseCaliber: String?,
            @SerializedName("Bazel_material")
            val bazelMaterial: Any?,
            @SerializedName("bazel_material_data")
            val bazelMaterialData: Any?,
            @SerializedName("bracelet_color")
            val braceletColor: BraceletColor?,
            @SerializedName("bracelet_color_id")
            val braceletColorId: Int?,
            @SerializedName("bracelet_length_longside")
            val braceletLengthLongside: Any?,
            @SerializedName("bracelet_length_shortside")
            val braceletLengthShortside: Any?,
            @SerializedName("bracelet_material")
            val braceletMaterial: BraceletMaterial?,
            @SerializedName("bracelet_material_id")
            val braceletMaterialId: Int?,
            @SerializedName("bracelet_thickness")
            val braceletThickness: Any?,
            @SerializedName("brand_id")
            val brandId: Int?,
            @SerializedName("brand_name")
            val brandName: BrandName?,
            @SerializedName("buckle_width")
            val buckleWidth: Any?,
            @SerializedName("caliber_movement")
            val caliberMovement: String?,
            @SerializedName("case_diameter_max")
            val caseDiameterMax: String?,
            @SerializedName("case_diameter_min")
            val caseDiameterMin: String?,
            @SerializedName("case_material")
            val caseMaterial: CaseMaterial?,
            @SerializedName("case_material_id")
            val caseMaterialId: Int?,
            @SerializedName("category")
            val category: Int?,
            @SerializedName("clasp_material")
            val claspMaterial: Any?,
            @SerializedName("Country")
            val country: String?,
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("crystal_type")
            val crystalType: Any?,
            @SerializedName("currency")
            val currency: Any?,
            @SerializedName("currency_id")
            val currencyId: Int?,
            @SerializedName("dealer_currency")
            val dealerCurrency: DealerCurrency?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("dial_color_id")
            val dialColorId: Int?,
            @SerializedName("dial_colour")
            val dialColour: DialColour?,
            @SerializedName("dial_number")
            val dialNumber: Any?,
            @SerializedName("frequency")
            val frequency: Any?,
            @SerializedName("frequency_type")
            val frequencyType: FrequencyType?,
            @SerializedName("function")
            val function: List<Any?>?,
            @SerializedName("gender")
            val gender: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("is_completed")
            val isCompleted: String?,
            @SerializedName("lug_width")
            val lugWidth: Any?,
            @SerializedName("model_number")
            val modelNumber: String?,
            @SerializedName("movement_type_id")
            val movementTypeId: Int?,
            @SerializedName("number_of_jewels")
            val numberOfJewels: String?,
            @SerializedName("others")
            val others: List<Any?>?,
            @SerializedName("power_reserve")
            val powerReserve: Any?,
            @SerializedName("price")
            val price: String?,
            @SerializedName("Product_condition_type")
            val productConditionType: ProductConditionType?,
            @SerializedName("product_conditions")
            val productConditions: ProductConditions?,
            @SerializedName("product_images")
            val productImages: List<ProductImage?>?,
            @SerializedName("reason")
            val reason: Any?,
            @SerializedName("refernece_number")
            val referneceNumber: String?,
            @SerializedName("scope_of_delivery")
            val scopeOfDelivery: ScopeOfDelivery?,
            @SerializedName("scope_of_delivery_id")
            val scopeOfDeliveryId: Int?,
            @SerializedName("serial_number")
            val serialNumber: String?,
            @SerializedName("shipment_charge")
            val shipmentCharge: ShipmentCharge?,
            @SerializedName("status")
            val status: String?,
            @SerializedName("thickness")
            val thickness: Any?,
            @SerializedName("type_of_clasp")
            val typeOfClasp: Any?,
            @SerializedName("updated_at")
            val updatedAt: String?,
            @SerializedName("user_id")
            val userId: String?,
            @SerializedName("user_type")
            val userType: String?,
            @SerializedName("watch_category")
            val watchCategory: WatchCategory?,
            @SerializedName("watch_material")
            val watchMaterial: WatchMaterial?,
            @SerializedName("Watch_type")
            val watchType: String?,
            @SerializedName("watch_type_data")
            val watchTypeData: WatchTypeData?,
            @SerializedName("watchmovement")
            val watchmovement: Watchmovement?,
            @SerializedName("water_resistance")
            val waterResistance: Any?,
            @SerializedName("year_of_production")
            val yearOfProduction: String?
        ) {
            data class AddToWishList(
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("product_id")
                val productId: Int?,
                @SerializedName("updated_at")
                val updatedAt: String?,
                @SerializedName("user_id")
                val userId: Int?,
                @SerializedName("user_type")
                val userType: String?
            )

            data class BraceletColor(
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class BraceletMaterial(
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class BrandName(
                @SerializedName("brand_name")
                val brandName: String?,
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("image")
                val image: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class CaseMaterial(
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class DealerCurrency(
                @SerializedName("created_at")
                val createdAt: Any?,
                @SerializedName("currency")
                val currency: String?,
                @SerializedName("currency_symbol")
                val currencySymbol: Any?,
                @SerializedName("dealerID")
                val dealerID: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("updated_at")
                val updatedAt: Any?
            )

            data class DialColour(
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class FrequencyType(
                @SerializedName("created_at")
                val createdAt: Any?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("updated_at")
                val updatedAt: Any?
            )

            data class ProductConditionType(
                @SerializedName("created_at")
                val createdAt: Any?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("updated_at")
                val updatedAt: Any?,
                @SerializedName("value")
                val value: String?
            )

            data class ProductConditions(
                @SerializedName("band_and_clasp_condition")
                val bandAndClaspCondition: String?,
                @SerializedName("bazel_condition")
                val bazelCondition: String?,
                @SerializedName("case_back_condition")
                val caseBackCondition: String?,
                @SerializedName("case_condition")
                val caseCondition: String?,
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("crystal_condition")
                val crystalCondition: String?,
                @SerializedName("dial_condition")
                val dialCondition: String?,
                @SerializedName("has_wear")
                val hasWear: Int?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("product_id")
                val productId: Int?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class ProductImage(
                @SerializedName("admin_remarks")
                val adminRemarks: Any?,
                @SerializedName("after_image")
                val afterImage: Any?,
                @SerializedName("before_image")
                val beforeImage: String?,
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("image_path")
                val imagePath: String?,
                @SerializedName("image_time")
                val imageTime: String?,
                @SerializedName("image_type")
                val imageType: String?,
                @SerializedName("is_primary")
                val isPrimary: Int?,
                @SerializedName("product_id")
                val productId: Int?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class ScopeOfDelivery(
                @SerializedName("created_at")
                val createdAt: Any?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: Any?
            )

            data class ShipmentCharge(
                @SerializedName("shipping_cost")
                val shippingCost: String?,
                @SerializedName("used_shipping")
                val usedShipping: String?,
                @SerializedName("used_shipping_cost_use")
                val usedShippingCostUse: UsedShippingCostUse?
            ) {
                data class UsedShippingCostUse(
                    @SerializedName("created_at")
                    val createdAt: Any?,
                    @SerializedName("dealer_id")
                    val dealerId: String?,
                    @SerializedName("dealer_unique_id")
                    val dealerUniqueId: String?,
                    @SerializedName("id")
                    val id: Int?,
                    @SerializedName("is_free_shipping")
                    val isFreeShipping: String?,
                    @SerializedName("item_price_max")
                    val itemPriceMax: String?,
                    @SerializedName("item_price_min")
                    val itemPriceMin: String?,
                    @SerializedName("shipping_cost")
                    val shippingCost: String?,
                    @SerializedName("shipping_type")
                    val shippingType: String?,
                    @SerializedName("updated_at")
                    val updatedAt: String?
                )
            }

            data class WatchCategory(
                @SerializedName("category_name")
                val categoryName: String?,
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("image")
                val image: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class WatchMaterial(
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class WatchTypeData(
                @SerializedName("created_at")
                val createdAt: Any?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("updated_at")
                val updatedAt: Any?
            )

            data class Watchmovement(
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )
        }

        data class ScopeOfDelivery(
            @SerializedName("created_at")
            val createdAt: Any?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("status")
            val status: String?,
            @SerializedName("updated_at")
            val updatedAt: Any?
        )

        data class SellerDetails(
            @SerializedName("companyName")
            val companyName: String?,
            @SerializedName("country")
            val country: String?,
            @SerializedName("country_code")
            val countryCode: String?,
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("first_name")
            val firstName: String?,
            @SerializedName("last_name")
            val lastName: String?,
            @SerializedName("mobile_number")
            val mobileNumber: String?,
            @SerializedName("seller_active_product")
            val sellerActiveProduct: Int?,
            @SerializedName("usertype")
            val usertype: String?
        )

        data class ShipmentCharge(
            @SerializedName("shipping_cost")
            val shippingCost: String?,
            @SerializedName("used_shipping")
            val usedShipping: String?,
            @SerializedName("used_shipping_cost_use")
            val usedShippingCostUse: Any?
        )

        data class WatchMaterial(
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("status")
            val status: String?,
            @SerializedName("updated_at")
            val updatedAt: String?
        )

        data class Watchmovement(
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("status")
            val status: String?,
            @SerializedName("updated_at")
            val updatedAt: String?
        )

        data class YouMayInterestProduct(
            @SerializedName("add_platformby")
            val addPlatformby: Int?,
            @SerializedName("add_to_wish_list")
            val addToWishList: Any?,
            @SerializedName("admin_approved")
            val adminApproved: String?,
            @SerializedName("base_caliber")
            val baseCaliber: String?,
            @SerializedName("Bazel_material")
            val bazelMaterial: Any?,
            @SerializedName("bazel_material_data")
            val bazelMaterialData: Any?,
            @SerializedName("bracelet_color")
            val braceletColor: BraceletColor?,
            @SerializedName("bracelet_color_id")
            val braceletColorId: Int?,
            @SerializedName("bracelet_length_longside")
            val braceletLengthLongside: Any?,
            @SerializedName("bracelet_length_shortside")
            val braceletLengthShortside: Any?,
            @SerializedName("bracelet_material")
            val braceletMaterial: BraceletMaterial?,
            @SerializedName("bracelet_material_id")
            val braceletMaterialId: Int?,
            @SerializedName("bracelet_thickness")
            val braceletThickness: Any?,
            @SerializedName("brand_id")
            val brandId: Int?,
            @SerializedName("brand_name")
            val brandName: BrandName?,
            @SerializedName("buckle_width")
            val buckleWidth: Any?,
            @SerializedName("caliber_movement")
            val caliberMovement: String?,
            @SerializedName("case_diameter_max")
            val caseDiameterMax: String?,
            @SerializedName("case_diameter_min")
            val caseDiameterMin: String?,
            @SerializedName("case_material")
            val caseMaterial: CaseMaterial?,
            @SerializedName("case_material_id")
            val caseMaterialId: Int?,
            @SerializedName("category")
            val category: Int?,
            @SerializedName("clasp_material")
            val claspMaterial: Any?,
            @SerializedName("Country")
            val country: String?,
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("crystal_type")
            val crystalType: Any?,
            @SerializedName("currency")
            val currency: Any?,
            @SerializedName("currency_id")
            val currencyId: Int?,
            @SerializedName("dealer_currency")
            val dealerCurrency: DealerCurrency?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("dial_color_id")
            val dialColorId: Int?,
            @SerializedName("dial_colour")
            val dialColour: DialColour?,
            @SerializedName("dial_number")
            val dialNumber: Any?,
            @SerializedName("frequency")
            val frequency: Any?,
            @SerializedName("frequency_type")
            val frequencyType: FrequencyType?,
            @SerializedName("function")
            val function: List<Any?>?,
            @SerializedName("gender")
            val gender: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("is_completed")
            val isCompleted: String?,
            @SerializedName("lug_width")
            val lugWidth: Any?,
            @SerializedName("model_number")
            val modelNumber: String?,
            @SerializedName("movement_type_id")
            val movementTypeId: Int?,
            @SerializedName("number_of_jewels")
            val numberOfJewels: String?,
            @SerializedName("others")
            val others: List<Any?>?,
            @SerializedName("power_reserve")
            val powerReserve: Any?,
            @SerializedName("price")
            val price: String?,
            @SerializedName("Product_condition_type")
            val productConditionType: ProductConditionType?,
            @SerializedName("product_conditions")
            val productConditions: ProductConditions?,
            @SerializedName("product_images")
            val productImages: List<ProductImage?>?,
            @SerializedName("reason")
            val reason: Any?,
            @SerializedName("refernece_number")
            val referneceNumber: String?,
            @SerializedName("scope_of_delivery")
            val scopeOfDelivery: ScopeOfDelivery?,
            @SerializedName("scope_of_delivery_id")
            val scopeOfDeliveryId: Int?,
            @SerializedName("serial_number")
            val serialNumber: String?,
            @SerializedName("shipment_charge")
            val shipmentCharge: ShipmentCharge?,
            @SerializedName("status")
            val status: String?,
            @SerializedName("thickness")
            val thickness: Any?,
            @SerializedName("type_of_clasp")
            val typeOfClasp: Any?,
            @SerializedName("updated_at")
            val updatedAt: String?,
            @SerializedName("user_id")
            val userId: String?,
            @SerializedName("user_type")
            val userType: String?,
            @SerializedName("watch_category")
            val watchCategory: Any?,
            @SerializedName("watch_material")
            val watchMaterial: WatchMaterial?,
            @SerializedName("Watch_type")
            val watchType: Any?,
            @SerializedName("watch_type_data")
            val watchTypeData: Any?,
            @SerializedName("watchmovement")
            val watchmovement: Watchmovement?,
            @SerializedName("water_resistance")
            val waterResistance: Any?,
            @SerializedName("year_of_production")
            val yearOfProduction: String?
        ) {
            data class BraceletColor(
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class BraceletMaterial(
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class BrandName(
                @SerializedName("brand_name")
                val brandName: String?,
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("image")
                val image: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class CaseMaterial(
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class DealerCurrency(
                @SerializedName("created_at")
                val createdAt: Any?,
                @SerializedName("currency")
                val currency: String?,
                @SerializedName("currency_symbol")
                val currencySymbol: Any?,
                @SerializedName("dealerID")
                val dealerID: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("updated_at")
                val updatedAt: Any?
            )

            data class DialColour(
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class FrequencyType(
                @SerializedName("created_at")
                val createdAt: Any?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("updated_at")
                val updatedAt: Any?
            )

            data class ProductConditionType(
                @SerializedName("created_at")
                val createdAt: Any?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("updated_at")
                val updatedAt: Any?,
                @SerializedName("value")
                val value: String?
            )

            data class ProductConditions(
                @SerializedName("band_and_clasp_condition")
                val bandAndClaspCondition: String?,
                @SerializedName("bazel_condition")
                val bazelCondition: String?,
                @SerializedName("case_back_condition")
                val caseBackCondition: String?,
                @SerializedName("case_condition")
                val caseCondition: String?,
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("crystal_condition")
                val crystalCondition: String?,
                @SerializedName("dial_condition")
                val dialCondition: String?,
                @SerializedName("has_wear")
                val hasWear: Int?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("product_id")
                val productId: Int?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class ProductImage(
                @SerializedName("admin_remarks")
                val adminRemarks: Any?,
                @SerializedName("after_image")
                val afterImage: Any?,
                @SerializedName("before_image")
                val beforeImage: String?,
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("image_path")
                val imagePath: String?,
                @SerializedName("image_time")
                val imageTime: String?,
                @SerializedName("image_type")
                val imageType: String?,
                @SerializedName("is_primary")
                val isPrimary: Int?,
                @SerializedName("product_id")
                val productId: Int?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class ScopeOfDelivery(
                @SerializedName("created_at")
                val createdAt: Any?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: Any?
            )

            data class ShipmentCharge(
                @SerializedName("shipping_cost")
                val shippingCost: String?,
                @SerializedName("used_shipping")
                val usedShipping: String?,
                @SerializedName("used_shipping_cost_use")
                val usedShippingCostUse: Any?
            )

            data class WatchMaterial(
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )

            data class Watchmovement(
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("status")
                val status: String?,
                @SerializedName("updated_at")
                val updatedAt: String?
            )
        }
    }
}


