# Specific commit and build options of raspa for DELIA Pi boards
PV = "1.1.0"
SRCREV = "9fa0b66a701e51f2a565587080936efbdcf7303d"

EXTRA_OECMAKE += "\
    -DCMAKE_BUILD_TYPE=Release \
    -DBUILD_GMOCK=FALSE \
    -DINSTALL_GTEST=FALSE \
    -DRASPA_WITH_TESTS=FALSE \
    -DRASPA_WITH_APPS=OFF \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
    -DWITH_UNIT_TESTS=FALSE \
    -DELK_PI_HAT=FALSE \
    -DNINA_PI_HAT=FALSE \
    -DMONIQUE_PI_HAT=TRUE \    
"
