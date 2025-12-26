public interface CatalogService {

    Crop addCrop(Crop crop);

    Fertilizer addFertilizer(Fertilizer fertilizer);

    List<Crop> findSuitableCrops(double soilPh, double rainfall, String season);

    List<Fertilizer> findFertilizersForCrops(List<String> crops);
}
